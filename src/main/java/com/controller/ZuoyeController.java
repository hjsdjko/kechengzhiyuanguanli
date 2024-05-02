package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.ZuoyeEntity;

import com.service.ZuoyeService;
import com.entity.view.ZuoyeView;
import com.service.KechengService;
import com.entity.KechengEntity;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.service.JiaoshiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 作业信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zuoye")
public class ZuoyeController {
    private static final Logger logger = LoggerFactory.getLogger(ZuoyeController.class);

    @Autowired
    private ZuoyeService zuoyeService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private KechengService kechengService;
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private JiaoshiService jiaoshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("学生".equals(role)){
            YonghuEntity userId = yonghuService.selectById((Integer) request.getSession().getAttribute("userId"));
            params.put("yonghuId",userId.getId());
        }
        else if("教师".equals(role)){
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = zuoyeService.queryPage(params);

        //字典表数据转换
        List<ZuoyeView> list =(List<ZuoyeView>)page.getList();
        for(ZuoyeView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZuoyeEntity zuoye = zuoyeService.selectById(id);
        if(zuoye !=null){
            //entity转view
            ZuoyeView view = new ZuoyeView();
            BeanUtils.copyProperties( zuoye , view );//把实体数据重构到view中

            //级联表
            KechengEntity kecheng = kechengService.selectById(zuoye.getKechengId());
            if(kecheng != null){
                BeanUtils.copyProperties( kecheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setKechengId(kecheng.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(zuoye.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZuoyeEntity zuoye, HttpServletRequest request){
        KechengEntity kecheng = kechengService.selectById(zuoye.getKechengId());
        logger.debug("save方法:,,Controller:{},,zuoye:{}",this.getClass().getName(),zuoye.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("学生".equals(role)){
            zuoye.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        if(StringUtils.isBlank(zuoye.getZuoyeFile())){
            zuoye.setZuoyeTypes(1);
        }else{
            zuoye.setInsertTime(new Date());
            if(new Date().getTime() <= kecheng.getKechengRenzhiyaoqiu().getTime()){
                zuoye.setZuoyeTypes(3);
            }else{
                zuoye.setZuoyeTypes(2);
            }
        }

        Wrapper<ZuoyeEntity> queryWrapper = new EntityWrapper<ZuoyeEntity>()
            .eq("kecheng_id", zuoye.getKechengId())
            .eq("yonghu_id", zuoye.getYonghuId())
            .eq("zuoye_types", zuoye.getZuoyeTypes())
            .eq("zuoye_pingfen", zuoye.getZuoyePingfen())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZuoyeEntity zuoyeEntity = zuoyeService.selectOne(queryWrapper);
        if(zuoyeEntity==null){
            zuoye.setCreateTime(new Date());
            zuoyeService.insert(zuoye);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZuoyeEntity zuoye, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zuoye:{}",this.getClass().getName(),zuoye.toString());
        ZuoyeEntity zuoyeEntity1 = zuoyeService.selectById(zuoye.getId());
        KechengEntity kecheng = kechengService.selectById(zuoye.getKechengId());
        if(StringUtils.isBlank(zuoyeEntity1.getZuoyeFile())){
            if(StringUtils.isNotBlank(zuoye.getZuoyeFile())){
                zuoye.setInsertTime(new Date());
                if(new Date().getTime() <= kecheng.getKechengRenzhiyaoqiu().getTime()){
                    zuoye.setZuoyeTypes(3);
                }else{
                    zuoye.setZuoyeTypes(2);
                }
            }else{
                zuoye.setZuoyeTypes(1);
            }
        }
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("学生".equals(role)){
            zuoye.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        //根据字段查询是否有相同数据
        Wrapper<ZuoyeEntity> queryWrapper = new EntityWrapper<ZuoyeEntity>()
            .notIn("id",zuoye.getId())
            .andNew()
            .eq("kecheng_id", zuoye.getKechengId())
            .eq("yonghu_id", zuoye.getYonghuId())
            .eq("zuoye_types", zuoye.getZuoyeTypes())
            .eq("zuoye_pingfen", zuoye.getZuoyePingfen())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZuoyeEntity zuoyeEntity = zuoyeService.selectOne(queryWrapper);
        if("".equals(zuoye.getZuoyeFile()) || "null".equals(zuoye.getZuoyeFile())){
                zuoye.setZuoyeFile(null);
        }
        if(zuoyeEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      zuoye.set
            //  }
            zuoyeService.updateById(zuoye);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 评分
    */
    @RequestMapping("/pingfen")
    public R pingfen(Integer ids,Integer pingfen){
        ZuoyeEntity zuoye = zuoyeService.selectById(ids);
        if(zuoye==null){
            return R.error();
        }
        if(pingfen == null){
            return R.error("评分不能为空");
        }
        zuoye.setZuoyePingfen(pingfen);
        boolean b = zuoyeService.updateById(zuoye);
        if(b){
            return R.ok();
        }
        return R.error();
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zuoyeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("学生".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        else if("教师".equals(role)){
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = zuoyeService.queryPage(params);

        //字典表数据转换
        List<ZuoyeView> list =(List<ZuoyeView>)page.getList();
        for(ZuoyeView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZuoyeEntity zuoye = zuoyeService.selectById(id);
            if(zuoye !=null){
                //entity转view
                ZuoyeView view = new ZuoyeView();
                BeanUtils.copyProperties( zuoye , view );//把实体数据重构到view中

                //级联表
                    KechengEntity kecheng = kechengService.selectById(zuoye.getKechengId());
                if(kecheng != null){
                    BeanUtils.copyProperties( kecheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKechengId(kecheng.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(zuoye.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZuoyeEntity zuoye, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zuoye:{}",this.getClass().getName(),zuoye.toString());
        Wrapper<ZuoyeEntity> queryWrapper = new EntityWrapper<ZuoyeEntity>()
            .eq("kecheng_id", zuoye.getKechengId())
            .eq("yonghu_id", zuoye.getYonghuId())
            .eq("zuoye_types", zuoye.getZuoyeTypes())
            .eq("zuoye_pingfen", zuoye.getZuoyePingfen())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZuoyeEntity zuoyeEntity = zuoyeService.selectOne(queryWrapper);
        if(zuoyeEntity==null){
            zuoye.setInsertTime(new Date());
            zuoye.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      zuoye.set
        //  }
        zuoyeService.insert(zuoye);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }





}


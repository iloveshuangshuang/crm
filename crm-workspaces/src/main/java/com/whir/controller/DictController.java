package com.whir.controller;

import com.whir.model.Dict;
import com.whir.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@Controller
public class DictController {

    @Autowired
    private DictService diceService;
    private HttpServletRequest request;
    private HttpServletResponse response;
    /*
    @RequestMapping(value = "/customer/list")
    public String find(Model model) {
        System.out.println("进入list");
        List<Dict> fromType = diceService.find("002");
        for(int i=0;i<fromType.size();i++){
            System.out.println(fromType.get(i));
        }
        model.addAttribute("fromType", fromType);
        return "customer";
    }
    */

    @RequestMapping(value = "/customer/list")
    public String find(HttpServletRequest request) {

        List<Dict> fromType = diceService.find("002");

        System.out.println("fromType"+fromType);

        request.setAttribute("fromType", fromType);

        return "customer";
    }

    @RequestMapping(value = "/customer/redis")
    public String findById(HttpServletRequest request) {
        System.out.println("进入redis");

        //String fromType = diceService.findById("003");

        //request.setAttribute("fromType", fromType);

        return "index";
    }

    @RequestMapping(value = "/customer/findtest")
    public String queryById() throws IOException {
        System.out.println("进入findtest");

        PrintWriter out = response.getWriter();

        String fromType = diceService.findById("002");

        out.write(fromType);
        out.flush();
        out.close();

        return null;
    }
    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request,HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.response.setContentType("text/html;charset=utf-8");
    }
}

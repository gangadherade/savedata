package com.example.savetodb.controller;

import java.util.List;

import com.example.savetodb.model.AppendixARequestObj;
import com.example.savetodb.model.AppendixARespObj;
import com.example.savetodb.model.AppendixASTNResponseObj;
import com.example.savetodb.model.StnCatSubCateg;
import com.example.savetodb.service.SaveAppendixAReqSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveToDBController {
   // create a controller method to save the data to the database
    @Autowired
    SaveAppendixAReqSvc saveAppendixAReqSvc;

    @PostMapping("/saveData")
    public AppendixARespObj saveDataToDB(@RequestBody AppendixARequestObj requestObj) {
        // generate a service class that takes data and saves it to the database
        List<StnCatSubCateg> stnCatSubCategList = requestObj.getStnCatSubCategList();
        AppendixARespObj appendixARespObj = new AppendixARespObj();
        appendixARespObj = saveAppendixAReqSvc.saveAppendixAReq(stnCatSubCategList);
        return appendixARespObj;

    }

}

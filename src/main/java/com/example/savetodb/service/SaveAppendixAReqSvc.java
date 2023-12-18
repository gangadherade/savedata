package com.example.savetodb.service;

import com.example.savetodb.model.AppendixARespObj;
import com.example.savetodb.model.AppendixASTNResponseObj;
import com.example.savetodb.model.AppendixaRequestTest;
import com.example.savetodb.model.StnCatSubCateg;
import com.example.savetodb.repo.AppendixaRequestTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SaveAppendixAReqSvc {
    @Autowired
    AppendixaRequestTestRepository appendixaRequestTestRepository;
        public AppendixARespObj saveAppendixAReq(List<StnCatSubCateg> stnCatSubCategList) {
            System.out.println("SaveAppendixAReqSvc.saveAppendixAReq() called");
            AppendixARespObj appendixARespObj = new AppendixARespObj();
            appendixARespObj.setAppendixASTNResponseObjList(new ArrayList<AppendixASTNResponseObj>());
               for (int i=0;i<stnCatSubCategList.size();i++) {
                   AppendixaRequestTest appendixaRequestTest = new AppendixaRequestTest();
                   StnCatSubCateg stnCatSubCateg = stnCatSubCategList.get(i);
                   appendixaRequestTest.setStn(stnCatSubCateg.getStn());
                   appendixaRequestTest.setCategory(stnCatSubCateg.getCategoryCode());
                   appendixaRequestTest.setSubcategory(stnCatSubCateg.getSubCategoryCode());
                   appendixaRequestTest.setId(UUID.randomUUID());
                   appendixaRequestTest.setArqProcessingStatus("PENDING");

                   String requestId = appendixaRequestTestRepository.save(appendixaRequestTest).getId().toString();
                   AppendixASTNResponseObj appendixASTNResponseObj = new AppendixASTNResponseObj();
                        appendixASTNResponseObj.setRequestid(requestId);
                        appendixASTNResponseObj.setStn(stnCatSubCateg.getStn());
                        appendixASTNResponseObj.setCategoryCode(stnCatSubCateg.getCategoryCode());
                        appendixASTNResponseObj.setSubCategoryCode(stnCatSubCateg.getSubCategoryCode());
                   appendixARespObj.getAppendixASTNResponseObjList().add(appendixASTNResponseObj);
               }


            return appendixARespObj;
        }



}

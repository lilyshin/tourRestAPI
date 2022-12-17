<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2022-12-18
  Time: 오전 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>REST</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            //ajaxSetup():  실행될  AJAX 요청에 대한 기본 속성을 정의해 재사용
            $.ajaxSetup({
                success:function(result){
                    alert(result);
                },
                error: function (jqXHR) {
                    alert("jqXHR status code:"+jqXHR.status+" message:"+jqXHR.responseText);
                }
            });//ajaxSetup
            $("#testGetListBtn").click(function(){
                $.ajax({
                    type:"get",
                    url:"products",
                    success:function(productList){
                        $("#listView").empty();
                        $.each(productList,function(i,product){
                            $("#listView").append(product.id+" "+product.name+" "+product.maker+" "+product.price+"<br>").css("background","pink");
                        });
                    }
                });//ajax
            });//click
            $("#testGetBtn").click(function(){
                $.ajax({
                    type:"get",
                    url:"products/"+$("#pid").val(),
                    success:function(product){
                        alert(product.id+" "+product.name+" "+product.maker+" "+product.price);
                    }
                });//ajax
            });//click
            $("#testCreateBtn").click(function(){
                $.ajax({
                    type:"post",
                    url:"products",
                    data:$("#createProductForm").serialize()
                }).done(function(){ // done - success 와 동일
                    $("#createProductForm")[0].reset();
                });//ajax
            });//click
            $("#testPutBtn").click(function(){
                $.ajax({
                    type:"put",
                    url:"products?"+$("#updateProductForm").serialize()
                }).always(function(){ // always 요청에 대한 처리가 success or fail 상관없이 항상 실행
                    $("#updateProductForm")[0].reset();
                });
            });//click

            $("#testDeleteBtn").click(function(){
                $.ajax({
                    type:"delete",
                    url:"products/"+$("#deleteId").val()
                });//ajax
            });//click
        });//ready
    </script>
    <style type="text/css">
        .restImg{
            width: 600px;
            height: 400px
        }
    </style>
</head>
<body>
<h3>여행지(도시) 관리 REST API</h3>
<ul>
    <li>
        도시 API <br><br>
        단일 도시 목록 <input type="button" value="조회" id="getCityList"><br>
        <div id="cityList"></div><br><br>
        사용자별 도시 목록 <input type="button" value="조회" id="getUesrCityList"><br>
        <div id="userCityList"></div><br><br>
        등록(POST) <input type="button" value="등록" id="createCity"><br>
        <form id="createCityForm">도시명 <input type="text" name="name" size="5"></form>
        <br><br>
        수정(PUT) <input type="button" value="수정" id="updateCity"><br>
        <form id="updateCityForm">
            도시코드 <input type="text" name="cityCd" size="5">
            도시명 <input type="text" name="cityNm" size="5">
        </form>
        <br>
        삭제(DELETE) <input type="button" value="삭제" id="deleteCity">
        <form id="deleteCityForm">
            도시코드 <input type="text" name="cityCd" size="5">
            도시명 <input type="text" name="cityNm" size="5">
        </form>
    </li>
    <br><br>
    <li>
        여행지 API <br><br>
        단일 여행지 목록 <input type="button" value="조회" id="gettourList"><br>
        <div id="tourList"></div><br><br>
        등록(POST) <input type="button" value="등록" id="createTour"><br>
        <form id="createTourForm">
            여행지명 <input type="text" name="name" size="5">
            시작일자 <input type="text" name="name" size="10">
            종료일자 <input type="text" name="name" size="10">
        </form>
        <br><br>
        수정(PUT) <input type="button" value="수정" id="updateTour"><br>
        <form id="updateTourForm">
            여행지코드 <input type="text" name="tourCd" size="5">
            여행지명 <input type="text" name="tourNm" size="5">
        </form>
        <br>
        삭제(DELETE) <input type="button" value="삭제" id="deleteTour">
        <form id="deleteTourForm">
            여행지코드 <input type="text" name="tourCd" size="5">
            여행지명 <input type="text" name="tourNm" size="5">
        </form>
    </li>
</ul>
</body>
</html>
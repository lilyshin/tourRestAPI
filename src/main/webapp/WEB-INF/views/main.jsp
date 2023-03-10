<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>여행(도시) 관리 REST API</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
    <script src="/js/main.js"></script>
</head>
<body>
<ul>
    <li>
        도시 API <br><br>
        단일 도시 목록 <input type="button" value="조회" id="getCityList"><br>
        <div id="cityList"></div><br><br>
        사용자별 도시 목록 <input type="button" value="조회" id="getUesrCityList"><br>
        <div id="userCityList"></div><br><br>
        등록(POST) <input type="button" value="등록" id="createCity"><br>
        <form id="createCityForm" method="post">도시명 <input type="text" title="도시명" name="cityNm" size="10"></form>
        <br><br>
        수정(PUT) <input type="button" value="수정" id="updateCity"><br>
        <form id="updateCityForm">
            도시코드 <input type="text" title="도시코드" name="cityCd" size="5">
            도시명 <input type="text" title="도시명" name="cityNm" size="5">
        </form>
        <br>
        삭제(DELETE) <input type="button" value="삭제" id="deleteCity">
        <form id="deleteCityForm">
            도시코드 <input type="text" title="도시코드" name="cityCd" size="5">
        </form>
    </li>
    <br><br>
    <li>
        여행 API <br><br>
        단일 여행 목록 <input type="button" value="조회" id="getTourList"><br>
        <div id="tourList"></div><br><br>
        등록(POST) <input type="button" value="등록" id="createTour"><br>
        <form id="createTourForm">
            여행명 <input type="text" title="여행명" name="tourNm" size="5">
            도시코드 <input type="text" title="도시코드" name="cityCd" size="5">
            사용자ID <input type="text" title="사용자ID" name="userId" size="5">
            시작일자 <input type="text" title="시작일자" name="tourStartDate" size="10" maxlength="8">
            종료일자 <input type="text" title="종료일자" name="tourEndDate" size="10" maxlength="8">
        </form>
        <br><br>
        수정(PUT) <input type="button" value="수정" id="updateTour"><br>
        <form id="updateTourForm">
            여행코드 <input type="text" title="여행코드" name="tourCd" size="5">
            여행명 <input type="text" title="여행명" name="tourNm" size="5">
            도시코드 <input type="text" title="도시코드" name="cityCd" size="5">
            시작일자 <input type="text" title="시작일자" name="tourStartDate" size="10" maxlength="8">
            종료일자 <input type="text" title="종료일자" name="tourEndDate" size="10" maxlength="8">
        </form>
        <br>
        삭제(DELETE) <input type="button" value="삭제" id="deleteTour">
        <form id="deleteTourForm">
            여행코드 <input type="text" title="여행코드" name="tourCd" size="5">
        </form>
    </li>
</ul>
</body>
</html>
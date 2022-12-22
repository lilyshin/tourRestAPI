$(document).ready(function(){
    // 단일 도시 조회
    $("#getCityList").click(function() {
        $.ajax({
            url:'/city',
            type:'GET',
            dataType:'json',
            success: function(data) {
                $("#cityList").empty();
                var tr = '<thead>'+
                    '<tr>' +
                    '<th>도시코드 </th>'+
                    '<th>도시명 </th>'+
                    '<th>등록일자 </th>'+
                    '<th>조회수 </th>'+
                    '</tr>'+
                    '</thead>';
                $.each(data , function(i){
                    tr += '<td>' + data[i].cityCd + '</td><td>' + data[i].cityNm + '</td><td>' + moment(data[i].regDate).format('YYYY-MM-DD HH:mm:ss') + '</td><td>' + data[i].viewCnt + '</td></tr>';
                });
                $("#cityList").append(tr);
            }
        });
    })

    // 도시 등록
    $("#createCity").click(function() {
        if (!submitFormNullCheck("createCityForm")) {
            return false;
        }

        $.ajax({
            url:'/city/create',
            type:'POST',
            data:JSON.stringify({ cityNm: $("#createCityForm input[type=text]").val() }),
            dataType:'json',
            contentType: 'application/json',
            success : function (data, status){
                console.log(data, status);
                alert("등록되었습니다.");
                $("#createCityForm")[0].reset();
                $("#getCityList").trigger("click");
            },

            error : function (jqXHR, status){
                debugger;
                alert(jqXHR.responseJSON.message);
            }
        });
    })

    // 도시 수정
    $("#updateCity").click(function() {
        if (!submitFormNullCheck("updateCityForm")) {
            return false;
        }

        var cityCd = $("#updateCityForm input[name='cityCd']").val();
        var cityNm = $("#updateCityForm input[name='cityNm']").val();

        $.ajax({
            url:'/city/update',
            type:'PUT',
            data:JSON.stringify({ cityCd: cityCd, cityNm: cityNm }),
            dataType:'json',
            contentType: 'application/json',
            success : function (data, status){
                console.log(data, status);
                alert("수정되었습니다.");
                $("#updateCityForm")[0].reset();
                $("#getCityList").trigger("click");
            },

            error : function (jqXHR, status){
                alert(jqXHR.responseJSON.message);
            }
        });
    })

    // 도시 삭제
    $("#deleteCity").click(function() {
        if (!submitFormNullCheck("deleteCityForm")) {
            return false;
        }

        $.ajax({
            url:'/city/delete/'+$("#deleteCityForm input[name='cityCd']").val(),
            type:'DELETE',
            dataType:'json',
            contentType: 'application/json',
            success : function (data, status){
                console.log(data, status);
                alert("삭제되었습니다.");
                $("#deleteCityForm")[0].reset();
                $("#getCityList").trigger("click");
            },

            error : function (jqXHR, status){
                alert(jqXHR.responseJSON.message);
            }
        });
    })

    // 단일 여행 조회
    $("#getTourList").click(function() {
        $.ajax({
            url:'/tour',
            type:'GET',
            dataType:'json',
            success: function(data) {
                $("#tourList").empty();
                var tr = '<thead>'+
                    '<tr>' +
                    '<th>여행코드 </th>'+
                    '<th>여행지명 </th>'+
                    '<th>도시코드 </th>'+
                    '<th>여행시작일자 </th>'+
                    '<th>여행종료일자 </th>'+
                    '</tr>'+
                    '</thead>';
                $.each(data , function(i){
                    tr += '<td>' + data[i].tourCd + '</td><td>' + data[i].tourNm + '</td><td>' + data[i].cityCd + '</td><td>' + data[i].tourStartDate + '</td><td>' + data[i].tourEndDate + '</td></tr>';
                });
                $("#tourList").append(tr);
            }
        });
    })

    // 여행 등록
    $("#createTour").click(function() {
        if (!submitFormNullCheck("createTourForm")) {
            return false;
        }

        var tourNm = $("#createTourForm input[name='tourNm']").val();
        var cityCd = $("#createTourForm input[name='cityCd']").val();
        var tourStartDate = $("#createTourForm input[name='tourStartDate']").val();
        var tourEndDate   = $("#createTourForm input[name='tourEndDate']").val();

        $.ajax({
            url:'/tour/create',
            type:'POST',
            data:JSON.stringify({ tourNm: tourNm, cityCd: cityCd, tourStartDate: tourStartDate, tourEndDate: tourEndDate }),
            dataType:'json',
            contentType: 'application/json',
            success : function (data, status){
                console.log(data, status);
                alert("등록되었습니다.");
                $("#createTourForm")[0].reset();
                $("#getTourList").trigger("click");
            },

            error : function (jqXHR, status){
                alert(jqXHR.responseJSON.message);
            }
        });
    })

    // 여행 수정
    $("#updateTour").click(function() {
        if (!submitFormNullCheck("updateTourForm")) {
            return false;
        }

        var tourCd = $("#updateTourForm input[name='tourCd']").val();
        var tourNm = $("#updateTourForm input[name='tourNm']").val();

        $.ajax({
            url:'/tour/update',
            type:'PUT',
            data:JSON.stringify({ tourCd: tourCd, tourNm: tourNm }),
            dataType:'json',
            contentType: 'application/json',
            success : function (data, status){
                console.log(data, status);
                alert("수정되었습니다.");
                $("#updateTourForm")[0].reset();
                $("#getTourList").trigger("click");
            },

            error : function (jqXHR, status){
                alert(jqXHR.responseJSON.message);
            }
        });
    })

    // 여행 삭제
    $("#deleteTour").click(function() {
        if (!submitFormNullCheck("deleteTourForm")) {
            return false;
        }

        $.ajax({
            url:'/tour/delete/'+$("#deleteTourForm input[name='tourCd']").val(),
            type:'DELETE',
            dataType:'json',
            contentType: 'application/json',
            success : function (data, status){
                console.log(data, status);
                alert("삭제되었습니다.");
                $("#deleteTourForm")[0].reset();
                $("#getTourList").trigger("click");
            },

            error : function (jqXHR, status){
                alert(jqXHR.responseJSON.message);
            }
        });
    })

    function submitFormNullCheck(form) {
        var chkVal = true;
        $("#"+form).find(':input').each(function(index) {
            if (!$(this).val()) {
                alert($(this).attr("title") + "를 입력해 주세요.");
                chkVal = false;
                return false;
            }
        });

        if (chkVal) {
            return true;
        }
    }
});
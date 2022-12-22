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
                    '<th>도시코드</th>'+
                    '<th>도시명</th>'+
                    '<th>등록일자</th>'+
                    '</tr>'+
                    '</thead>';
                $.each(data , function(i){
                    tr += '<td>' + data[i].cityCd + '</td><td>' + data[i].cityNm + '</td><td>' + moment(data[i].regDate).format('YYYY-MM-DD HH:mm:ss') + '</td></tr>';
                });
                $("#cityList").append(tr);
            }
        });
    })

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
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
        console.log($("#createCityForm").serialize());
        var data = { cityNm: $("#createCityForm input[type=text]").val() }
        debugger;
        $.ajax({
            url:'/city',
            type:'POST',
            data:JSON.stringify(data),
            dataType:'json',
            contentType: 'application/json',
            success: function() {
                $("#getCityList").click();
            }
        });
    })

});
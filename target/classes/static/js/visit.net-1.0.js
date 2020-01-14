window.onload = function(){
    $.ajax( {  
        type : "POST",  
        url : "/ip/getVisitIp",  
        timeout : 20000,  
        cache : false,  
        success : function(data, textStatus) {
            var ip = data;
            url = "https://api.map.baidu.com/location/ip?ak=CG6sA9yMCmx9NeESy5j6YtjHeMYvpnMV&ip="+ip+"&coor=bd09ll";
            $.ajax({  
            	 type: 'GET',
                 url : url,
                 cache : false,
                 dataType: 'jsonp',// 数据类型
                 success : function(result) {
                	 console.log("address-->"+result.address);
                	 console.log("address-->"+result.content.address);
                	 console.log("province-->"+result.content.address_detail.province);
                	 console.log("city-->"+result.content.address_detail.city);
                	 console.log("street-->"+result.content.street);
                	 console.log("x-->"+result.content.point.x);
                	 console.log("y-->"+result.content.point.y);
                	 $.ajax({  
                    	 type: 'POST',
                         url : "/access/log",
                         cache : false,
                         data : {
                        	 "ip":ip,
                        	 "address":result.content.address,  
                             "province":result.content.address_detail.province,  
                             "city":result.content.address_detail.city,  
                             "x":result.content.point.x,
                             "y":result.content.point.y,
                         },
                         success : function(result) {
                        	 console.log("访问日志添加成功");
                         },
                         error: function (){
                        	 console.log("访问日志添加失败");
                         }
                    });
                 },
                 error: function (){
                	 console.log("获取信息记录失败");
                 }
            });
        }
    }); 
}
$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + '/game/list',
        datatype: "json",
        colModel: [			
			{ label: '会员账号', name: 'playername', width: 130 },
			{ label: '用户名', name: 'realname', width: 70 },
            { label: '注单数', name: 'notesCount', sortable: false, width: 60,hidden: true },
            { label: '投注额', name: 'betamount', sortable: false, width: 90 },
            { label: '有效投注额', name: 'validbetamount', sortable: false, width: 90 },
            { label: '输赢金额', name: 'netamount', sortable: false, width: 80 },
			{ label: '会员下注', name: 'betTypeValue', width: 120 },
			{ label: '游戏结果', name: 'status', width: 60, formatter: function(value, options, row){
				var result='';
            	if(value=='BAC' || value=='CBAC' || value=='LBAC' || value=='SBAC' || value=='ZJH'){
            		result=commonAnalyze(row.bankerPoint,row.playerpoint,1);
            	}else if(value=='BJ'){
            		result=BJAnalyze(row.bankerPoint,row.playerpoint,row.remark);
            	}else if(value=='DT'){
            		result=commonAnalyze(row.dragonpoint,row.tigerpoint,0);
            	}else if(value=='NN'){
            		result=analyzeNN(row.bankerPoint,row.playerpoint);
            	}else if(value=='ROU'){
            		result=row.cardlist
            	}else if(value=='SHB'){
            		result='骰子1:'+row.cardlist.split(',')[0]+'点;骰子2:'+row.cardlist.split(',')[0]+'点;骰子3:'+row.cardlist.split(',')[0]+'点';
            	}else  if(value=="BF"){
                    result=analyzeDN(row.bankerPoint,row.playerpoint);
				}
            	return result;
			}},
			{ label: '游戏类型', name: 'gameTypeName', width: 70},
			{ label: '桌号', name: 'tablecode', width: 60 },
			{ label: '局号', name: 'gamecode', width: 110 },
			{ label: '投注时间', name: 'bettime', width: 130 },
			{ label: '注单流水号', name: 'billno', width: 120,index: 'billno',key: true },
			{ label: '结算状态', name: 'flag', width: 60 }
        ],
		viewrecords: true,
       // height: 578,
        rowNum: 25,
		rowList : [25,50,100],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
       // multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
        	root: "data.list",
            page: "data.page",
            total: "data.totalPage",
            records: "data.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "auto" }); 
        }
    });
});

var vm = new Vue({
    el:'#gameList',
    data:{
        q:{
        	cagent: '',
        	isGroupByUser: '',
        	isRealTimeQuery: '',
        	type: '',
            name: '',
            platForm: '',
            startTime: '',
            endTime: ''
        },
        showList: true,
        title:null,
        roleList:{},
    },
    methods: {
    	commonAnalyze: function(bankerPoint,playerpoint,type){
    		if(type==1){
    			return '庄:'+bankerPoint+'点;闲:'+playerpoint+'点';
    		}else if(type==0){
    			return '龙:'+bankerPoint+'点;虎:'+playerpoint+'点';
    		}
    	},
    	analyzeDN: function(){
    	    var blackCow ;
    	    var redCow ;
    	    if(bankerPoint=="0"){
    			blackCow = "无牛";
    		}else if(bankerPoint=="1"){
    	        blackCow = "牛一";
    		}else if(bankerPoint=="2"){
                blackCow = "牛二";
            }else if(bankerPoint=="3"){
                blackCow = "牛三";
            }else if(bankerPoint=="4"){
                blackCow = "牛四";
            }else if(bankerPoint=="5"){
                blackCow = "牛五";
            }else if(bankerPoint=="6"){
                blackCow = "牛六";
            }else if(bankerPoint=="7"){
                blackCow = "牛七";
            }else if(bankerPoint=="8"){
                blackCow = "牛八";
            }else if(bankerPoint=="9"){
                blackCow = "牛九";
            }else if(bankerPoint=="10"){
                blackCow = "牛牛";
            }else if(bankerPoint=="11"){
                blackCow = "银牛";
            }else if(bankerPoint=="12"){
                blackCow = "金牛";
            }else if(bankerPoint=="13"){
                blackCow = "炸弹";
            }else if(bankerPoint=="14"){
                blackCow = "五小牛";
            }
            if(playerpoint=="0"){
                redCow = "无牛";
            }else if(playerpoint=="1"){
                redCow = "牛一";
            }else if(playerpoint=="2"){
                redCow = "牛二";
            }else if(playerpoint=="3"){
                redCow = "牛三";
            }else if(playerpoint=="4"){
                redCow = "牛四";
            }else if(playerpoint=="5"){
                redCow = "牛五";
            }else if(playerpoint=="6"){
                redCow = "牛六";
            }else if(playerpoint=="7"){
                redCow = "牛七";
            }else if(playerpoint=="8"){
                redCow = "牛八";
            }else if(playerpoint=="9"){
                redCow = "牛九";
            }else if(playerpoint=="10"){
                redCow = "牛牛";
            }else if(playerpoint=="11"){
                redCow = "银牛";
            }else if(playerpoint=="12"){
                redCow = "金牛";
            }else if(playerpoint=="13"){
                redCow = "炸弹";
            }else if(playerpoint=="14"){
                redCow = "五小牛";
            }
            return result ="黑牛"+blackCow+";红牛"+redCow;
    	},
    	BJAnalyze: function(bankerPoint,playerpoint,remark){
    	    var result='庄：'+bankerPoint.split(",")[2]+" 点;玩家：";
    	    var playR=playerpoint.split("\|");
    	    var card;
    	    if(playR.length<remark){
    	        return '';
    		}else{
    	        card=playR[remark-1].split(",");
    	        result+= card[3]+" 点; 玩家 ";
    	        if(card[5]==0){
                    result+="输";
    			}else if(card[5]==1){
                    result+="赢";
    			}else if(card[5]==2){
                    result+="和";
                }
    		}
    		return result;
    	},
    	analyzeNN: function(bankerPoint,playerpoint){
    		var result='庄:'+niuNumber(bankerPoint)+';';
    		var group=playerpoint.split('\|');
    		var winLoss='';
    		for(var i=0;i<group.length;i++){
    			winLoss=group[i].split(';')
    			result=result+'闲'+(i+1)+':'+niuNumber(winLoss[0])+'-';
    			result=result+(winLoss[1]==0?'输':'赢')+'|';
    		}
    		return result;
    	},
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{
                	cagent: '',
                	isGroupByUser: '',
                	isRealTimeQuery: '',
                	type: '',
                    name: '',
                    platForm: '',
                    startTime: '2019-04-25 00:00:00',
                    endTime: '2019-04-25 23:59:59'
            	},
                page:page
            }).trigger("reloadGrid");
        }
    }
});
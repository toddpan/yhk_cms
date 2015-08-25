window.onload = initPage;


function initPage() {
	/*alert("init()");*/
	
	document.getElementById("highGL").onclick=showLife;

	


	var labbtns = document.getElementById("labTab").getElementsByTagName("li");
	for (var k = 0; k < labbtns.length; k++) {
		var labbtn = labbtns[k];
		labbtn.onclick = labItemClick;
	}
	var tables=document.getElementById("labResult").getElementsByClassName("table");
	for (var i=0;i<tables.length;i++){
		tables[i].style.visibility="hidden";
	}

}
function showLife(){
	alert('饮食：超量，喝了酒；'+ '\n' + '运动：当日没运动');
	
}

function labItemClick() {
	var labbtns = document.getElementById("labTab").getElementsByTagName("li");
	for (var k = 0; k < labbtns.length; k++) {
		var labbtn = labbtns[k];
		labbtn.className = "square";
	}
	this.className = "check";
	var labResultDiv=document.getElementById("labShow");
	/*var labShowChild=labResultDiv.firstChild;
	while(labShowChild.nodeName=="#text"){
		labShowChild=labShowChild.nextSibling;
	}*/
	labResultDiv.removeChild(document.getElementById("labShowChild"));
	
	var id=this.id;
	/*alert(id);*/
	var targetResult = document.getElementById(id + "Result");
	var targetResultClone=targetResult.cloneNode(true);
	targetResultClone.setAttribute("id",id+"Show");
	var labShowChildNew=document.createElement("div");
	labShowChildNew.setAttribute("id","labShowChild");
	
	labShowChildNew.appendChild(targetResultClone);
	labResultDiv.appendChild(labShowChildNew);
	
	var childShow=document.getElementById("labShowChild").firstChild;
	while(childShow.nodeName=="#text"){
		childShow=childShow.nextSibling;
	}
	childShow.style.visibility="visible";
	
}







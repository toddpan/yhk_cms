window.onload = initPage;


function initPage() {
	/*alert("init()");*/

	var diagnosisBtn = document.getElementById("diagnosisBtn");
	diagnosisBtn.onclick = addDiagosis;

	var examBtn = document.getElementById("examBtn");
	examBtn.onclick = addExam;
	var prescriptionBtn = document.getElementById("prescriptionBtn");
	prescriptionBtn.onclick = addPrescription;

	var diseaselist = document.getElementsByClassName("diseaseName");
	for (var i = 0; i < diseaselist.length; i++) {
		diseaselist[i].onclick = autoaddDisease;
	}
	var examlist = document.getElementsByClassName("examlist");
	for (var i = 0; i < examlist.length; i++) {
		examlist[i].onclick = autoaddExam;
	}
	checkdisease();
}

function checkdisease() {
	/*alert("hi");*/
	var liList = document.getElementById("diagnosisUl").getElementsByTagName("li");
	var prescritionNode=document.getElementById("prescriptionShow");
	var prescriptionShowChildren=prescritionNode.childNodes;
	for (var k=prescriptionShowChildren.length;k>0;k--){
		
		prescritionNode.removeChild(prescriptionShowChildren[k-1]);
	}
	
	for (var i=0;i<liList.length;i++){
		if(liList[i].firstChild!=null){
			var disease=liList[i].firstChild.nodeValue;
			/*var diseasetitle=escape(disease);*/
			if(disease=="高血压"){
				var targetNode=document.getElementById("hypertensionPre");
				var cloneNode=targetNode.cloneNode(true);
				cloneNode.style.visibility="visible";
				cloneNode.setAttribute("id","hypertensionPreNew");
				prescritionNode.appendChild(cloneNode);
				var drugs=document.getElementById("hypertensionPreNew").getElementsByTagName("li");
			for (var t=0;t<drugs.length;t++){
				drugs[t].onclick=autoAddDrugs;
			}
			}
			else if(disease=="高血脂"){
				var targetNode=document.getElementById("hyperbloodfat");
				var cloneNode=targetNode.cloneNode(true);
				cloneNode.style.visibility="visible";
				cloneNode.setAttribute("id","hyperbloodfatNew");
				prescritionNode.appendChild(cloneNode);
				var drugs=document.getElementById("hyperbloodfatNew").getElementsByTagName("li");
			for (var t=0;t<drugs.length;t++){
				drugs[t].onclick=autoAddDrugs;
			}
			}
		}
		
	}
}

function autoAddDrugs(){
	var prescriptionNode = this.firstChild;
	var prescriptionValue;
	if (prescriptionNode != null) {
		prescriptionValue = prescriptionNode.nodeValue;
	}

	if (prescriptionValue != "") {
		var li = document.createElement("li");
		var text = document.createTextNode(prescriptionValue);
		var deleteBtn = document.createElement("button");
		var ul = document.getElementById("prescriptionUl");
		var index = ul.childNodes.length;
		var id = "prescriptionLi" + index;
		deleteBtn.setAttribute("id", id);
		var btnText = document.createTextNode("删除");
		deleteBtn.appendChild(btnText);
		deleteBtn.onclick = deleteItem;
		li.setAttribute("id", id + "Li");
		li.appendChild(text);
		li.appendChild(deleteBtn);
		var infoText = document.createTextNode("本品通过肝代谢，病人有肝功能损伤，请检查是否使用");
		var infoli=document.createElement("div");
		infoli.setAttribute("class","warning");
		infoli.appendChild(infoText);
		li.appendChild(infoli);
		ul.appendChild(li);
		
	}
	
	
}

function autoaddExam() {
	var examNode = this.firstChild;
	var examValue;
	if (examNode != null) {
		examValue = examNode.nodeValue;
	}

	if (examValue != "") {
		var li = document.createElement("li");
		var text = document.createTextNode(examValue);
		var deleteBtn = document.createElement("button");
		var ul = document.getElementById("examUl");
		var index = ul.childNodes.length;
		var id = "examLi" + index;
		deleteBtn.setAttribute("id", id);
		var btnText = document.createTextNode("删除");
		deleteBtn.appendChild(btnText);
		deleteBtn.onclick = deleteItem;
		li.setAttribute("id", id + "Li");
		li.appendChild(text);
		li.appendChild(deleteBtn);
		ul.appendChild(li);
	}
}

function autoaddDisease() {
	var diseaseNode = this.firstChild.firstChild;
	var diseaseValue;
	if (diseaseNode != null) {
		diseaseValue = diseaseNode.nodeValue;
	}

	if (diseaseValue != "") {
		var li = document.createElement("li");
		var text = document.createTextNode(diseaseValue);
		var deleteBtn = document.createElement("button");
		var ul = document.getElementById("diagnosisUl");
		var index = ul.childNodes.length;
		var id = "diagnosisLi" + index;
		deleteBtn.setAttribute("id", id);
		var btnText = document.createTextNode("删除");
		deleteBtn.appendChild(btnText);
		deleteBtn.onclick = deleteItem;
		li.setAttribute("id", id + "Li");
		li.appendChild(text);
		li.appendChild(deleteBtn);
		ul.appendChild(li);
	}
	checkdisease();
}

function addPrescription() {
	var prescriptionNode = document.getElementById("prescriptionName");
	var prescriptionValue = prescriptionNode.value;

	if (prescriptionValue != "") {
		var li = document.createElement("li");
		var text = document.createTextNode(prescriptionValue);
		var deleteBtn = document.createElement("button");
		var ul = document.getElementById("prescriptionUl");
		var index = ul.childNodes.length;
		var id = "prescriptionLi" + index;
		deleteBtn.setAttribute("id", id);
		var btnText = document.createTextNode("删除");
		deleteBtn.appendChild(btnText);
		deleteBtn.onclick = deleteItem;
		li.setAttribute("id", id + "Li");
		li.appendChild(text);
		if (prescriptionValue == "ACEI") {

		}
		li.appendChild(deleteBtn);
		ul.appendChild(li);
	}

	prescriptionNode.value = "";


}

function addDiagosis() {
	var diagnosisNode = document.getElementById("diagnosisName");
	var diagnosisValue = diagnosisNode.value;

	if (diagnosisValue != "") {
		var li = document.createElement("li");
		var text = document.createTextNode(diagnosisValue);
		var deleteBtn = document.createElement("button");
		var ul = document.getElementById("diagnosisUl");
		var index = ul.childNodes.length;
		var id = "diagnosisLi" + index;
		deleteBtn.setAttribute("id", id);
		var btnText = document.createTextNode("删除");
		deleteBtn.appendChild(btnText);
		deleteBtn.onclick = deleteItem;
		li.setAttribute("id", id + "Li");
		li.appendChild(text);
		li.appendChild(deleteBtn);
		ul.appendChild(li);
	}

	diagnosisNode.value = "";

	checkdisease();
}

function addExam() {
	var examNode = document.getElementById("examName");
	var examValue = examNode.value;

	if (examValue != "") {
		var li = document.createElement("li");
		var text = document.createTextNode(examValue);
		var deleteBtn = document.createElement("button");
		var ul = document.getElementById("examUl");
		var index = ul.childNodes.length;
		var id = "examLi" + index;
		deleteBtn.setAttribute("id", id);
		var btnText = document.createTextNode("删除");
		deleteBtn.appendChild(btnText);
		deleteBtn.onclick = deleteItem;
		li.setAttribute("id", id + "Li");
		li.appendChild(text);
		li.appendChild(deleteBtn);
		ul.appendChild(li);
	}

	examNode.value = "";


}

function deleteItem() {
	var id = this.id;
	var li = document.getElementById(id + "Li");
	var parent = li.parentNode;
	parent.removeChild(li);
}
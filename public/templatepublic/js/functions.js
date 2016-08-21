function highlightModel(element) {
	element.style.background = '#F6F6F6';
}

function unHighlightModel(element) {
	var classes = element.className.split(" ");
	var isActive = false;
	for (i = 0; i < classes.length; i++) {
		if (classes[i] == 'active') {
			isActive = true;
		}
	}
	if (!isActive) {
		element.style.background = 'white';
	}
}

function chooseModel(element) {
	element.style.background = '#F6F6F6';
	element.classList;
	element.classList.add('active');
	var currentElement = element.id;
	var hiddenModel = document.getElementById('model');
	hiddenModel.value = currentElement;
	var models = [ 'model1', 'model2', 'model3' ];
	for ( var mod in models) {
		var model = models[mod];
		if (currentElement != model) {
			var m = document.getElementById(model);
			m.classList.remove('active');
			m.style.background = 'white';
		}
	}
}

function saveChildrenChalkBoard() {
	if ($('#model').val() == '') {
		$("#message").show();
		$("#message").html('Favor, escolha um modelo!');
		setTimeout('$("#message").hide()', 5000);
		anchorToPayment();
		return;
	} else {
		var jsonChalkBoard = getJsonChalkBoardChildren();
		if(JSON.stringify(jsonChalkBoard) === '{}') {
			$("#message").show();
			$("#message").html('Favor, preencha os campos do ChalkBoard!');
			setTimeout('$("#message").hide()', 5000);
			anchorToPayment();
			return;
		}
		$
				.ajax({
					type : 'POST',
					url : '/save-new-children-chalkboard',
					dataType : 'json',
					data : jsonChalkBoard,
					success : function(data) {
						$("#message").show();
						$("#message").html(
						'Pedido salvo com sucesso! Efetue o pagamento para efetivação!');
						setTimeout('$("#message").hide()', 5000);
						anchorToPayment();
					},
					error : function(data) {
						$("#message").show()
						$("#message")
								.html(
										'Ocorreu um erro ao salvar. Por favor, tente novamente. :(');
						setTimeout('$("#message").hide()', 5000);
						anchorToPayment();
					}
				});
		return false;
	}
}

function getJsonChalkBoardChildren() {
	var jsonChalkChildren = new Object();
	jsonChalkChildren.model = $('#model').val();
	jsonChalkChildren.name = $('#name').val();
	jsonChalkChildren.birthDay = $('#birthDay').val();
	jsonChalkChildren.age = $('#age').val();
	jsonChalkChildren.bornHeight = $('#bornHeight').val();
	jsonChalkChildren.bornWeight = $('#bornWeight').val();
	jsonChalkChildren.heightNow = $('#heightNow').val();
	jsonChalkChildren.weightNow = $('#weightNow').val();
	jsonChalkChildren.teeth = $('#teeth').val();
	jsonChalkChildren.likeToDo1 = $('#likeToDo1').val();
	jsonChalkChildren.likeToDo2 = $('#likeToDo2').val();
	jsonChalkChildren.likeToDo3 = $('#likeToDo3').val();
	jsonChalkChildren.likeToDo4 = $('#likeToDo4').val();
	jsonChalkChildren.likeToWatch1 = $('#likeToWatch1').val();
	jsonChalkChildren.likeToWatch2 = $('#likeToWatch2').val();
	jsonChalkChildren.know1 = $('#know1').val();
	jsonChalkChildren.know2 = $('#know2').val();
	jsonChalkChildren.know3 = $('#know3').val();
	jsonChalkChildren.likeToEat1 = $('#likeToEat1').val();
	jsonChalkChildren.likeToEat2 = $('#likeToEat2').val();
	jsonChalkChildren.firstWord1 = $('#firstWord1').val();
	jsonChalkChildren.firstWord2 = $('#firstWord2').val();
	jsonChalkChildren.firstWord3 = $('#firstWord3').val();
	jsonChalkChildren.nickName1 = $('#nickName1').val();
	jsonChalkChildren.nickName2 = $('#nickName2').val();
	jsonChalkChildren.nickName3 = $('#nickName3').val();
	var outputJson = JSON.stringify(jsonChalkChildren);
	return outputJson;
}

function anchorToPayment() {
	document.getElementById('toPayment').click();	
}
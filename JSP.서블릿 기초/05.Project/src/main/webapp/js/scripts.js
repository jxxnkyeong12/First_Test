/*!
    * Start Bootstrap - SB Admin v7.0.5 (https://startbootstrap.com/template/sb-admin)
    * Copyright 2013-2022 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */
    // 
// Scripts
// 
//$(function(){
	
	$('#attach-file').on('change', function(){
		//console.log(this.files[0]);
		var attached = this.files[0];
		if( attached ){
			$('#delete-file').css('display', 'inline');
		}else {
			$('#delete-file').css('display', 'none');
		}
	});

//첨부파일 삭제 클릭시 
	$('#delete-file').on('click', function(){
		alert('삭제되었습니다')
		$('#attach-file').val('');
		$('#delete-file').css('display','none');
		
	});
	
	
	function emptyCheck(){
		var ok = true;
		$('.chk').each(function(){
			if( $(this).val()=='' ){
				alert( $(this).attr('title')+ '을 입력하세요');
				$(this).focus();
				ok = false;
				return ok;
			}
		});
		return ok;
	}
	
//});


window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

});

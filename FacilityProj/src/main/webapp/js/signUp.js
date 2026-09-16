$(function() {
	var empPw = $('#pw');
	var empPw2 = $('#pw2');

	$('#signUpForm').submit(function() {
		if (empPw.val() != empPw2.val()) {
			alert('비밀번호를 확인해주세요.');
			empPw2.focus();
			return false;
		}
		
		return true;
	});

	$('#cancelBtn').click(function() {
		location.href = '/';
	});
});
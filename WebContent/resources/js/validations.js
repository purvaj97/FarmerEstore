
function validatepass()
{
	var nm1=document.getElementById("createpass").value;
	var nm2=document.getElementById("repeatpass").value;
    var myp=document.getElementById("msg");
	

      
		
		  if(nm1==nm2)
		{		  
			return true;
		}
		
		else{
			myp.innerHTML="password not matching";
			return false;
		}
		  
		
}
function makePayment()
{
	
    var myp2=document.getElementById("msg2");

      
		alert("are you sure ...");
		 
			myp2.innerHTML="Order placed successfully";
			return true;
		
		  
		
}

<%@ page session="false" %>

<p>
Please login to the web application.
</p>

<form action='j_security_check' method='POST'>

User Name: <input type='text' name='j_username' size='16' /> 
<br/><br/>

Password: <input type='password' name='j_password' size='16' />
<br/><br/>

<input type='submit' value='Login' />

</form>

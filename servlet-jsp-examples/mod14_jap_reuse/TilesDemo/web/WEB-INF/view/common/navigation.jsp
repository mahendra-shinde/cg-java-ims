<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <table border='0' cellspacing='0' cellpadding='0' width='160'>

    <tr height='40' valign='bottom' align='center'>
      <td height='40' width='20'></td>
      <td height='40' width='140'>
        <font size='3' color='red' face='Helvetica, san-serif'>
        <b>Members</b>
        </font>
      </td>
    </tr>
    <tr height='10'>
      <td height='10' width='20'></td>
      <td height='10' width='140' valign='center'>
        <hr width='90%' size='3' noshade>
      </td>
    </tr>
    <tr valign='top'>
      <td width='20' align='center'>
         <img src='<c:url value="/images/bullet.gif"/>' />
      </td>
      <td width='140'>
         <a href='<c:url value="/list_leagues.jsp" />'>
           List all leagues
         </a>
      </td>
    </tr>
    <tr height='5'>
      <td colspan=2 height='5'><!-- vertical space --></td>
    </tr>
    <tr valign='top'>
      <td width='20' align='center'>
         <img src='<c:url value="/images/bullet.gif"/>' />
      </td>
      <td width='140'>
         <a href='<c:url value="/register/select_league.jsp" />'>
           Register for league
         </a>
      </td>
    </tr>
    <tr height='5'>
      <td colspan=2 height='5'><!-- vertical space --></td>
    </tr>
    <tr valign='top'>
      <td width='20' align='center'>
         <img src='<c:url value="/images/bullet.gif"/>' />
      </td>
      <td width='140'>
         View team rosters (TBA)
      </td>
    </tr>
    <tr height='5'>
      <td colspan=2 height='5'><!-- vertical space --></td>
    </tr>
    <tr valign='top'>
      <td width='20' align='center'>
         <img src='<c:url value="/images/bullet.gif"/>' />
      </td>
      <td width='140'>
        View schedule (TBA)
      </td>
    </tr>

    <tr height='40' valign='bottom' align='center'>
      <td height='40' width='20'></td>
      <td height='40' width='140'>
        <font size='3' color='red' face='helvetica, san-serif'>
        <b>Administrators</b>
        </font>
      </td>
    </tr>
    <tr height='10'>
      <td height='10' width='20'></td>
      <td height='10' width='140' valign='center'>
        <hr width='90%' size='3' noshade>
      </td>
    </tr>
    <tr valign='top'>
      <td width='20' align='center'>
         <img src='<c:url value="/images/bullet.gif"/>' />
      </td>
      <td width='140'>
         <a href='<c:url value="/admin/add_league.jsp" />'>
           Add a new league
         </a>
      </td>
    </tr>

    <tr height='15'>
      <td height='15' colspan='2'><!-- vertical space --></td>
    </tr>

    </table>

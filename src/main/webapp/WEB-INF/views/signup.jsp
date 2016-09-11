<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<h1>Rejestracja:</h1>
<form name="login" method="POST"  action="${pageContext.request.contextPath}/reg" >
                        <!-- <fieldset>-->
                        <table>
                        <tr>
                            <div class="form-group">
                               <td>Email: </td><td><input class="form-control" placeholder="E-mail" name="email" type="login" autofocus></td>
                            </div>
                            </tr><tr>
                            <div class="form-group">
                              <td>Powtorz Email: </td><td><input class="form-control" placeholder="E-mail" name="email2" type="login" autofocus></td>
                            </div>
                            </tr><tr>
                            <div class="form-group">
                                <td>Haslo: </td><td><input class="form-control" placeholder="Password" name="haslo" type="password" value=""></td>
                            </div>
                            </tr><tr>
                            <div class="form-group">
                                <td>Powtorz Haslo:</td><td> <input class="form-control" placeholder="Password" name="haslo2" type="password" value=""></td>
                            </div>
                            </tr><tr>
                             <div class="form-group">
                                <td>Imie: </td><td><input class="form-control" placeholder="Imie" name="imie" type="text" value=""></td>
                            </div>
                            </tr><tr>
                             <div class="form-group">
                                <td>Nazwisko: </td><td><input class="form-control" placeholder="Nazwisko" name="nazwisko" type="text" value=""></td>
                            </div>
                            </tr><tr>
                             <div class="form-group">
                                <td>Telefon: </td><td><input class="form-control" placeholder="Telefon" name="tel" type="text" value=""></td>
                            </div>
                            </tr><tr>
                             <div class="form-group">
                                <td>Pesel: </td><td><input class="form-control" placeholder="Pesel" name="pesel" type="text" value=""></td>
                            </div>
                            </tr><tr>
                            <div style="color: red">${error}</div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <!-- Change this to a button or input when using this as a form -->
                            <td></td><td><button type="submit" class="btn btn-success btn-block">Zarejestruj</button></td>
                       </tr>
                       </table>
                       <!-- </fieldset>-->
</form>

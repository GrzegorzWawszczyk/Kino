<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>




<form name="login" method="POST"  action="${pageContext.request.contextPath}/reg" >
                        <fieldset>
                            <div class="form-group">
                               Email: <input class="form-control" placeholder="E-mail" name="email" type="login" autofocus>
                            </div>
                            <div class="form-group">
                              Powtorz Email: <input class="form-control" placeholder="E-mail" name="email2" type="login" autofocus>
                            </div>
                            <div class="form-group">
                                Haslo: <input class="form-control" placeholder="Password" name="haslo" type="password" value="">
                            </div>
                            <div class="form-group">
                                Powtorz Haslo: <input class="form-control" placeholder="Password" name="haslo2" type="password" value="">
                            </div>
                             <div class="form-group">
                                Imie: <input class="form-control" placeholder="Imie" name="imie" type="text" value="">
                            </div>
                             <div class="form-group">
                                Nazwisko: <input class="form-control" placeholder="Nazwisko" name="nazwisko" type="text" value="">
                            </div>
                             <div class="form-group">
                                Telefon: <input class="form-control" placeholder="Telefon" name="tel" type="text" value="">
                            </div>
                             <div class="form-group">
                                Pesel: <input class="form-control" placeholder="Pesel" name="pesel" type="text" value="">
                            </div>
                            <div style="color: red">${error}</div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <!-- Change this to a button or input when using this as a form -->
                            <button type="submit" class="btn btn-success btn-block">Login</button>
                        </fieldset>
</form>

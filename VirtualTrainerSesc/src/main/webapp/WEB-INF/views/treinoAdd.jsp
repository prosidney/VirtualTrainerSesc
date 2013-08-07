<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<layout:page title="VirtualTrainer" description="Listagem de usuário" keywords="amazing, app, VirtualSescTrainer" user="Admin">
    <jsp:body>
		<center>
			<h4>Novo Treino</h4>
			<form:form action="add/save" id="form" commandName="treinoForm" method="post" class="navbar-form pull-center">
				<table>
					<form:hidden path="id"/>
					<tr>
						<td>Aluno:</td>
						<td><c:out value="${aluno.nome}"/></td>
					</tr>							
					<tr>
						<td>Nome:</td>
						<td><form:input path="nome" class="span3"/></td>
					</tr>
					<tr>
						<td>Qtde Total:</td>
						<td><form:input path="qtdeTotal" value="0" class="span3" maxlength="2" style="width: 30px"/></td>
					</tr>
					<tr>
						<td>Qtide realizado:</td>
						<td><form:input path="qtde" value="0" class="span3" readonly="true" style="width: 30px"/></td>
					</tr>										
					<tr>
						<td colspan="2">
						<center>
							<a class="btn" href="#" onclick="document.forms[0].submit()"><i class="icon-plus-sign icon-black"></i> Salvar</a>
						</center>
						</td>
					</tr>				
				</table>
			</form:form>
		</center>
    </jsp:body>
</layout:page>
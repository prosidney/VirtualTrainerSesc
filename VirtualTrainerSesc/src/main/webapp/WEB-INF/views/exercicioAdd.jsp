<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<layout:page title="VirtualTrainerSesc" description="Listagem de usuário" keywords="amazing, app, VirtualTrainer" user="${sessionScope.usuarioLogado.nome}">
    <jsp:body>
		<center>
			<h4>Novo exercicio</h4>
			<form:form action="add/save" id="form" commandName="exercicioForm" method="post" class="navbar-form pull-center">
				<table>
					<form:hidden path="id"/>
					<tr>
						<td>Treino:</td>
						<td><c:out value="${treino.nome}"/></td>
					</tr>							
					<tr>
						<td>Musculatura:</td>
						<td><form:input path="musculatura" class="span3" /></td>
					</tr>
					<tr>
						<td>Qualidade:</td>
						<td><form:input path="qualidade" class="span3"/></td>
					</tr>																
					<tr>
						<td>Equipamento:</td>
						<td><form:textarea path="equipamento" class="span3"/></td>
					</tr>
					<tr>
						<td>Execução:</td>
						<td><form:textarea path="execucao" class="span3"/></td>
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
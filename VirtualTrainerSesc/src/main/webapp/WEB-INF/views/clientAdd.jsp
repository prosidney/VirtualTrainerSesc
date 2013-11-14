<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<layout:page title="VirtualTrainerSesc" description="Listagem de usuário" keywords="amazing, app, VirtualTrainer" user="${sessionScope.usuarioLogado.nome}">
    <jsp:body>
		<center>
			<h4>Novo Cliente</h4>
			<form:form action="saveClient.do" id="form" commandName="alunoForm" method="post" class="navbar-form pull-center">
				<table>
					<tr>
						<td>Nome:</td>
						<td><form:input path="nome" class="span3"/></td>
					</tr>																
					<tr>
						<td>Matricula:</td>
						<td><form:input path="matricula" class="span3" /></td>
					</tr>
					<tr>
						<td>Idade:</td>
						<td><form:input path="idade" class="span3" /></td>
					</tr>
					<tr>
						<td>Peso:</td>
						<td><form:input path="peso" class="span3"/></td>
					</tr>
					<tr>
						<td>Senha:</td>
						<td><form:input path="senha" class="span3"/></td>
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
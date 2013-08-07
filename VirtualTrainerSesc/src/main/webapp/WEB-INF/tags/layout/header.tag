<%@ tag body-content="empty" description="Header tag file"%>

<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="user" required="true" description="User logged" %>
<div id="header" class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a> 
			<a class="brand" href="<c:url value='/pages/admin'/>"/> VirtualTrainer </a>
			<div class="nav-collapse collapse">
				<p class="navbar-text pull-right">
					Logado como <a href="#" class="navbar-link"> <c:out	value="${user}" />
					</a>
				</p>
				<ul class="nav">
					<li class="active"><a href="<c:url value="/pages/admin"/>"> Principal</a></li>
					<li><a href="<c:url value='/pages/about'/>">Sobre</a></li>
					<li><a href="#contact">Contato</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Cadastros <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class="nav-header">Administração</li>
							<li><a href="<c:url value="/pages/admin"/>">Administração de Alunos</a></li>
							<li><a href="#" onclick="window.alert('Trial version')">Administração da academia</a></li>
							<li class="divider"></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>

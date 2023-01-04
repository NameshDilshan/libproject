<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<c:set var="serverContext" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Main Dashboard</title> 
        <%@include file="common/header.jsp"%> 
    </head>
    <body class="sb-nav-fixed">
    	<%@include file="common/navbar.jsp"%>  
        <div id="layoutSidenav">
        	<%@include file="common/sidebar.jsp"%> 
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Dashboard</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ol>  
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card text-white mb-4" style="background-color: #788AA3">
                                    <div class="card-body">Primary Card</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><svg class="svg-inline--fa fa-angle-right" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="angle-right" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 256 512" data-fa-i2svg=""><path fill="currentColor" d="M64 448c-8.188 0-16.38-3.125-22.62-9.375c-12.5-12.5-12.5-32.75 0-45.25L178.8 256L41.38 118.6c-12.5-12.5-12.5-32.75 0-45.25s32.75-12.5 45.25 0l160 160c12.5 12.5 12.5 32.75 0 45.25l-160 160C80.38 444.9 72.19 448 64 448z"></path></svg><!-- <i class="fas fa-angle-right"></i> Font Awesome fontawesome.com --></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card text-white mb-4" style="background-color: #92B6B1">
                                    <div class="card-body">Warning Card</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><svg class="svg-inline--fa fa-angle-right" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="angle-right" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 256 512" data-fa-i2svg=""><path fill="currentColor" d="M64 448c-8.188 0-16.38-3.125-22.62-9.375c-12.5-12.5-12.5-32.75 0-45.25L178.8 256L41.38 118.6c-12.5-12.5-12.5-32.75 0-45.25s32.75-12.5 45.25 0l160 160c12.5 12.5 12.5 32.75 0 45.25l-160 160C80.38 444.9 72.19 448 64 448z"></path></svg><!-- <i class="fas fa-angle-right"></i> Font Awesome fontawesome.com --></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Success Card</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><svg class="svg-inline--fa fa-angle-right" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="angle-right" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 256 512" data-fa-i2svg=""><path fill="currentColor" d="M64 448c-8.188 0-16.38-3.125-22.62-9.375c-12.5-12.5-12.5-32.75 0-45.25L178.8 256L41.38 118.6c-12.5-12.5-12.5-32.75 0-45.25s32.75-12.5 45.25 0l160 160c12.5 12.5 12.5 32.75 0 45.25l-160 160C80.38 444.9 72.19 448 64 448z"></path></svg><!-- <i class="fas fa-angle-right"></i> Font Awesome fontawesome.com --></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-danger text-white mb-4">
                                    <div class="card-body">Danger Card</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><svg class="svg-inline--fa fa-angle-right" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="angle-right" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 256 512" data-fa-i2svg=""><path fill="currentColor" d="M64 448c-8.188 0-16.38-3.125-22.62-9.375c-12.5-12.5-12.5-32.75 0-45.25L178.8 256L41.38 118.6c-12.5-12.5-12.5-32.75 0-45.25s32.75-12.5 45.25 0l160 160c12.5 12.5 12.5 32.75 0 45.25l-160 160C80.38 444.9 72.19 448 64 448z"></path></svg><!-- <i class="fas fa-angle-right"></i> Font Awesome fontawesome.com --></div>
                                    </div>
                                </div>
                            </div>
                        </div>
<!--                         <div class="card mb-4"> -->
<!--                             <div class="card-header"> -->
<!--                                 <i class="fas fa-table me-1"></i> -->
<!--                                 DataTable Example -->
<!--                             </div>  -->
<!--                             <div class="card-body">  -->
<!--                                 <table id="datatable-buttons" class="table table-striped table-bordered dt-responsive nowrap" style="border-collapse: collapse; border-spacing: 0; width: 100%;"> -->
<!--                                             <thead> -->
<!--                                                 <tr> -->
<!--                                                     <th>#</th>  -->
<!--                                                     <th>Guest Id</th> -->
<!--                                                     <th>Guest Name</th>  -->
<!-- 													<th>Edit</th> -->
<!--                                                 </tr> -->
<!--                                             </thead>   -->
<!--                                             <tbody> -->
<%--                                             <c:set var="count" value="0" scope="page" /> --%>
<%-- 											<c:forEach varStatus="loopCounter" items="${guestList}" var="guest"> --%>
<%-- 												<c:choose> --%>
<%-- 													<c:when test="${not empty guest }"> --%>
<!-- 														<tr> -->
<%-- 															<c:set var="count" value="${count + 1}" scope="page" /> --%>
<%-- 															<td><c:out value="${count}"></c:out></td>  --%>
<%-- 															<td><c:out value="${guest.id}"></c:out></td> --%>
<%-- 															<td><c:out value="${guest.name}"></c:out></td>  --%>
<!-- 															<td> -->
<!-- 																<button type="button" class="btn btn-outline-primary waves-effect waves-light col-md-5 editBtn"  >Edit</button> &nbsp; -->
<!-- 																<button type="button" id ="deleteBtnId" class="btn btn-outline-danger waves-effect waves-light col-md-5 deleteBtn" >Delete</button> -->
<!-- 															</td> -->
<!-- 														</tr> -->
<%-- 													</c:when> --%>
<%-- 												</c:choose> --%>
<%-- 											</c:forEach>  --%>
<!--                                             </tbody> -->
<!--                                         </table> -->
<!--                             </div> -->
<!--                         </div> -->
                    </div>
                </main>
                 <%@include file="common/footer.jsp"%>  
            </div>
        </div> 
        <%@include file="common/scripts.jsp"%> 
        <script>  
//         $.ajax({
// 			type : "GET",
// 			url : "http://localhost:8080/guests",
// 			contentType: "application/json; charset=utf-8",
// 	        data: "",
// 	        async: true, 
// 	        cache: false,
// 	        processData: false,
// 			success : function(response) {
// 				console.log(response);
// 			},
// 			error : function(e) {
// 				console.log(e);
// 			}
// 		}); 
        
//         var map = new Map();
// 		$(".editBtn").click(function() { 
// 			$(this).closest('tr').find('td').each(function(index) {
// 			      var textval = $(this).text();
// 			       map.set(index, textval);
// 			   });
// 			$("#modelId").val(map.get(1)); 
// 			}); 
		
        </script>
    </body>
</html> 
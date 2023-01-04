<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<c:set var="serverContext" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Student Fine Report Dashboard</title> 
        <%@include file="../common/header.jsp"%>  
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css"   />
		<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js" ></script>
		<link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap5.min.css"   />
		<script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js" ></script>
		<script src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js" ></script>
    </head>
    <body class="sb-nav-fixed">
    	<%@include file="../common/navbar.jsp"%>  
        <div id="layoutSidenav">
        	<%@include file="../common/sidebar.jsp"%> 
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h3 class="mt-4">Book Loan History Report</h3>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item ">Reports</li>
                            <li class="breadcrumb-item active">Book Loan History</li>
                        </ol> 
					<div class="row">
						<div class="col-md-6">
							<div class="card text-center">
								<div class="card-body">
									<div class="py-4">
										<div class="col-md-12">
											<label for="student" class="form-label">Student</label> 
											<select id="student" name="student" class="form-control">
												<option selected="selected" disabled="disabled" value="">Choose...</option>
												<c:forEach items="${students}" var="student">
													<option value="${student.regno}" id="${ student.name }">${ student.name }</option>
												</c:forEach>
											</select>
										</div>
										<div class="col-md-12">
											<label for="book" class="form-label">Book</label> 
											<select id="book" name="book" class="form-control">
												<option selected="selected" disabled="disabled" value="">Choose...</option>
												<c:forEach items="${books}" var="book">
													<option value="${book.id}">${ book.title }</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-md-6 ">
							<div class="card text-center">
								<div class="card-body ">
									<div class="py-4">
										<div class="form-group mb-0">
											<label>Select Date Range</label>
											<div class="mt-3">
												<div class="input-daterange input-group" id="date-range">
													<input id="start" type="text" class="form-control" name="start"> 
													<input id="end" type="text" class="form-control" name="end">
												</div>
											</div>
										</div>
										<br />
										<div>
											<div class=" text-center">
												<br />
												<button id="searchBtn"
													class=" btn btn-outline-primary col-md-4">Search</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
<!--                   ============================================================== -->
<!--                   					   TABLE START  								-->
<!--                   ============================================================== -->  
                        
<!--                        <div class="card mt-4"> -->
<!--                            <div class="card-header"><i class="fas fa-table me-1"></i> DataTable Example </div>  -->
<!--                            <div class="card-body">  -->
							<div class="mt-4">
								<table id="datatable" class="table table-striped table-bordered dt-responsive nowrap" style="border-collapse: collapse; border-spacing: 0; width: 100%;">
                                	<thead>
                                    	<tr> 
	                                     	<th>#</th> 
		                                    <th>ID</th>
		                                    <th>Book Id</th> 
		                                    <th>Book Name</th> 
		                                    <th>Student Register No</th>
											<th>Student Name</th>
											<th>Issued Date</th>
											<th>Due Date</th>
											<th>Returned Date</th>
											<th>Fine</th> 
                                        </tr>
                                     </thead>  
                                     <tbody> 
                                     </tbody>
                               </table>
							</div> 
<!--                            </div> -->
<!--                        </div> -->
                    </div>
                </main>
                 <%@include file="../common/footer.jsp"%>  
            </div>
        </div> 
        <%@include file="../common/scripts.jsp"%> 
        <script>  
		$("#date-range").datepicker({
            toggleActive: !0,
            format: 'yyyy-mm-dd',
            orientation: "bottom"
        });
		$('#datatable').DataTable();
// 		$('#datatable').DataTable({
// 				"paging" : true,
// 				"lengthChange" : true,
// 				"searching" : false,
// 				"ordering" : true,
// 				"info" : true,
// 				"autoWidth" : false,
// 				dom: 'Bfrtip',
// 		        buttons: ['copy', 'csv', 'excel', 'pdf', 'print']
// 		});
		
		
	var globelJsonResponse;
		$("#searchBtn").click( function (){ 
			var startDate = $("#start").val(); 
			var endDate = $("#end").val();
			var book = $('#book').find(":selected").val();
			var student = $('#student').find(":selected").val(); 
				$.ajax({
					  type: "POST",
				      url: "findIssuesByBookIdAndStudentIdAndIssuedDateRange",
				      data: {
				    	  "start": startDate,
				    	  "end" : endDate,
				    	  "book" : book, 
				    	  "student" : student 
				      },
				      success: function(result) {
				          console.log( result);
				          if(result != null){
				        	  populateTable(result);
			              }else{
			            	  console.log("Report table data not found");
			              }
				      }, error: function(error) {
				    	  Swal.fire(
			        			  'Report Table Loading Failed !!',
			        			  'Please try again.',
			        			  'error'
			        			);
				      }
				   });
			});	
					
		function populateTable(searchData) {
				var tableID = '#datatable';
				var mytable;
				if ($.fn.dataTable.isDataTable(tableID)) {
					mytable = $(tableID).DataTable();
				} else {
					mytable = $(tableID).DataTable({
						paging : false
					});
				}
				mytable.clear().draw();
				var No = 0;
				var FrontEndStatus = "";
				for ( var key in searchData) {
					if (searchData.hasOwnProperty(key)) {
						var val = searchData[key];
						No++; 
						//check every object key value pairs  and pass '-' for blank values 
						Object.keys(val).forEach(function(l){null!=val[l]&&"undefined"!=val[l]&&""!=val[l].length||(val[l]="-")}); 
						var rowNode = mytable.row.add(
								[   No,
									val.id,
									val.book_id,
									val.book_name,
									val.student_regno,
									val.student_name,
									val.issued_date,
									val.due_date,
									val.returned_date,
									val.fine   
									 ]).node();
						mytable.draw();
					}
				}
			}
		
		
        </script>
    </body>
</html> 
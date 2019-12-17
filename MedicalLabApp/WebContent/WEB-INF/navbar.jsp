<style>
     <%@ include file="css/acceuil.css"%>
     <%@ include file="css/bootstrap.min.css"%>
</style>

<!-- Vertical navbar -->
<div class="vertical-nav bg-white" id="sidebar">
  <div class="py-4 px-3 mb-4 bg-light">
    <div class="media d-flex align-items-center"><img src="https://www.med.tn/img/labo.png" alt="..." width="65" class="mr-3 img-thumbnail shadow-sm">
      <div class="media-body">
      <c:if test="${ !empty sessionScope.username }">
        <h4 class="m-0">${ sessionScope.username }</h4>
        <p class="font-weight-light text-muted mb-0">${ sessionScope.type }</p></c:if>
      </div>
    </div>
  </div>

  <p class="text-gray font-weight-bold text-uppercase px-3 small pb-4 mb-0">E-Laboratory</p>

  <ul class="nav flex-column bg-white mb-0">
    <li class="nav-item">
      <a href="/MedicalLaboratoryApp/Accueil" class="nav-link text-dark font-italic ">
                <i class="fa fa-th-large mr-3 text-primary fa-fw"></i>
                Accueil
            </a>
    </li>
    <li class="nav-item">
      <a href="/MedicalLaboratoryApp/patients" class="nav-link text-dark font-italic bg-light">
                <i class="fa fa-user mr-3 text-primary fa-fw"></i>
                Les patients
            </a>
    </li>
    <li class="nav-item">
      <a href="/MedicalLaboratoryApp/tests" class="nav-link text-dark font-italic">
                <i class="fa fa-cubes mr-3 text-primary fa-fw"></i>
                Les tests
            </a>
    </li>
  
    <li class="nav-item">
      <a href="#" class="nav-link text-dark font-italic">
                <i class="fa fa-area-chart mr-3 text-primary fa-fw"></i>
              Les Rapports 
            </a>
    </li>
    <li class="nav-item">
      <a href="/MedicalLaboratoryApp/factures" class="nav-link text-dark font-italic">
                <i class="fa fa-bar-chart mr-3 text-primary fa-fw"></i>
                Les factures
            </a>
    </li>
    </ul>
  
</div>
<!-- End vertical navbar -->
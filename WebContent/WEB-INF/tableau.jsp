<!DOCTYPE html>
<html>
    
    <head>
        <title>${ tableau.nomTableau }</title>
        <!-- Bootstrap -->
         <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="assets/styles.css" rel="stylesheet" media="screen">
        <link href="assets/DT_bootstrap.css" rel="stylesheet" media="screen">
        <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="vendors/flot/excanvas.min.js"></script><![endif]-->
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <style type="text/css">
        #containerIntro h2,
        #containerIntro p {
            margin-left: 5px;
            display: inline;
            vertical-align: bottom;
            font-family: 'Open Sans', sans-serif;
        }
        .inline div{
            margin-left: 5px;
            display: inline;
            vertical-align: bottom;
            font-family: 'Open Sans', sans-serif;
        }.boody{
            width: 100%;
            height: 129px;
            background-color: #e1e1e1;
            /* margin-top: 30px; */
            text-align: center;
        }.top{
            width: 100%;
            height: 40px;
            background-color: #999999;
            margin-top: 10px;
            text-align: center;
        }
    </style>
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">TimeManager</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> Vincent Gabriel <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a tabindex="-1" href="#">Profile</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a tabindex="-1" href="login.html">Logout</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav">
                            <li class="active">
                                <a href="#">Dashboard</a>
                            </li>
                            
                        </ul>
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span1"></div>
                <!--/span-->
                <div class="span10" id="content" style="margin-left: 10px">

                    <div class="row-fluid">
                        
                        <div class="navbar">
                            <div class="navbar-inner">
                                <ul class="breadcrumb">
                                    <i class="icon-chevron-left hide-sidebar"><a href='#' title="Hide Sidebar" rel='tooltip'>&nbsp;</a></i>
                                    <i class="icon-chevron-right show-sidebar" style="display:none;"><a href='#' title="Show Sidebar" rel='tooltip'>&nbsp;</a></i>
                                    <li>
                                        <a href="#">Dashboard</a> <span class="divider">/</span>    
                                    </li>
                                    <li>
                                        <a href="tableaux">Projets</a> <span class="divider">/</span>    
                                    </li>
                                    <li class="active">${ tableau.nomTableau }</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                       <div class="span12" style="margin-left: 0px;margin-right: 10px">
                            <!-- block -->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left">${ tableau.nomTableau }</div>
                                    <div class="pull-right"><span class="badge badge-info">${ tableau.nbrTags }</span>
                                    </div>
                                </div>
                                <div class="block-content collapse in" >
                                    <div class="span12">
                                        <div id="containerIntro">
                                            <h2>${ tableau.nomTableau }</h2>
                                            <p style="margin-bottom: 5px"><i class="fa fa-calendar"></i>&nbsp;&nbsp;De&nbsp;&nbsp; <i class="icon-time"></i> 20/12/2015 &nbsp;à&nbsp;&nbsp; <i class="icon-time"></i> 15/01/2016 </p>
                                        </div>
                                    </div>
                                    <div class="span12">
                                        <div class="span6">
                                           <br>
                                           <h5><i class="fa fa-align-justify" aria-hidden="true" style="color:#999" ></i> Description</h5>
                                           <p style="width: 100%; height: 160px" onclick="document.getElementById('textArea').style.display='block';document.getElementById('butt').style.display='block';this.style.display='none';">Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié. Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus récemment, par son inclusion dans des 
                                            </p>
                                            <textarea id="textArea" class="" placeholder="Enter text ..." style="width: 100%; height: 160px;display: none;" >Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié. Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus récemment, par son inclusion dans des 
                                            </textarea>
                                        </div>
                                        <div class="span2">
                                           <br>
                                           <h5><i class="icon-time" aria-hidden="true" style="color:#999" ></i> Date creation</h5>
                                           <p style="width: 100%;" onclick="document.getElementById('dateCreation').style.display='block';document.getElementById('butt').style.display='block';this.style.display='none';">20/12/2018</p>
                                            <input  id="dateCreation" style="display: none;width: auto;" type="date" class="input-xlarge datepicker" id="date01" value="20/12/2018">
                                            
                                           <h5><i class="icon-time" aria-hidden="true" style="color:#999" ></i> Date debut</h5>
                                           <p style="width: 100%;" onclick="document.getElementById('dateDebut').style.display='block';document.getElementById('butt').style.display='block';this.style.display='none';">20/12/2018</p>
                                            <input id="dateDebut" style="display: none;width: auto;" type="date" class="input-xlarge datepicker" id="date01" value="20/12/2018">
                                            
                                           <h5><i class="icon-time" aria-hidden="true" style="color:#999" ></i> Date fin</h5>
                                           <p style="width: 100%;" onclick="document.getElementById('dateFin').style.display='block';document.getElementById('butt').style.display='block';this.style.display='none';">20/12/2018</p>
                                            <input id="dateFin" style="display: none;width: auto;" type="date" class="input-xlarge datepicker" id="date01" value="20/12/2018">

                                        </div>
                                        <div class="span3" style="">
                                            <div style="margin-top: 30px;background-color: #999999">
                                              <div class="top">
                                                <h3>Vendredi</h3></div>
                                              <div class="boody">
                                                  <h3>MAR</h3>
                                                  <h1>15</h1>
                                                  <h6>2016</h6>
                                              </div>
                                            </div>
                                          
                                        </div>
                                    </div>
                                    <div class="span12">
                                        <span class="span4">
                                            <h5>Tâches</h5>
                                            <div class="span4">
                                                <i class="fa fa-check-circle fa-3x" style="color:#999">15</i>                                              
                                            </div>
                                            <div class="span4">
                                                <i class="fa fa-minus-circle fa-3x" style="color:#999">5</i>                                              
                                            </div>
                                            <div class="span3">
                                                <i class="fa fa-refresh fa-3x" style="color:#999">17 </i>                                            
                                            </div>
                                        </span>
                                        <span class="span7" style="background-color: ">
                                            <h5>Priorité des tâches</h5>
                                            <div class="span4">
                                                <i class="fa fa-thermometer-full fa-2x" style="color:#999">15 Haute</i>                                              
                                            </div>
                                            <div class="span4">
                                                <i class="fa fa-thermometer-half fa-2x" style="color:#999">5 Normale</i>                                             
                                            </div>
                                            <div class="span3">
                                                <i class="fa fa-thermometer-empty fa-2x" style="color:#999">17 Basse</i>                                            
                                            </div>
                                        </span>
                                    </div>
                                    <span class="span5">
                                        <h5>Tags</h5>
                                        <p>JavaEE / projet integre / etudes / network / pc</p>
                                        
                                    </span>
                                    <span class="span2">
                                         <div class="block">
                                            <div class="navbar navbar-inner block-header">
                                                <div class="muted pull-left">Commits</div>
                                            </div>
                                            <div class="block-content collapse in" >
                                                
                                                <div class="span12">
                                                    <i class="fa fa-share-alt fa-2x" style="color:#999">15</i>                                              
                                                </div>
                                            </div>
                                        </div>
                                    </span>
                                    <span class="span4">
                                         <div class="block">
                                            <div class="navbar navbar-inner block-header">
                                                <div class="muted pull-left">checklists</div>
                                            </div>
                                            <div class="block-content collapse in" >
                                                
                                                <div class="span5">
                                                    <i class="fa fa-check-square fa-2x" style="color:#999">6 Fait</i>                                              
                                                </div>
                                                <div class="span6">
                                                    <i class="fa fa-th-list fa-2x" style="color:#999">15 Totale</i>                                              
                                                </div>
                                            </div>
                                        </div>
                                    </span>
                                    <span class="span3" id="butt" style="float: right;display: none;">
                                        <input type="submit" class="btn btn-large btn-block" value='Enregistrer les modifications'/>
                                    </span>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                        
                        <div class="span12" style="margin-left: 0px;margin-right: 10px">
                            <!-- block -->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left">Taches de  ${ tableau.nomTableau }</div>
                                    <div class="pull-right"><span class="badge badge-info">${ tableau.nbrTags }</span>
                                    </div>
                                </div>
                                <div class="block-content collapse in" >
                                    <div class="span12">
                                       <div class="table-toolbar">
                                          <div class="btn-group">
                                             <a href="#myModal" data-toggle="modal"><button class="btn btn-success">Ajouter nouveau <i class="icon-plus icon-white"></i></button></a>
                                          </div>
                                          
                                       </div>
                                        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example2">
                                            <thead>
                                                <tr>
                                                    <th width="35%">Titre</th>
                                                    <th width="25%">Avancement</th>
                                                    <th width="14%">Date Debut </th>
                                                    <th width="14">Date fin</th>
                                                    <th width="12%"></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${ listes }" var="liste">
                                                <tr class="odd gradeX">
                                                    <td width="">
                                                        <div class="span12" style="">
                                                            ${ liste.nomListe }
                                                        </div>
                                                        <div class="span2" style="">
                                                            <i class="fa fa-align-justify" aria-hidden="true" style="color:#999" ></i>
                                                        </div>
                                                        <div class="span2" >
                                                            <i class="fa fa-list" aria-hidden="true" style="color:#999"></i>
                                                        </div>
                                                        <div class="span3" >
                                                            <span ><i class="fa fa-tags" aria-hidden="true" style="color:#999"></i>&nbsp;4</span>
                                                        </div>
                                                        <div class="span3" >
                                                            <span ><i class="fa fa-share-alt" aria-hidden="true" style="color:#999"></i>&nbsp;12</span>
                                                        </div>
                                                    </td>
                                                    <td class="center"> 
                                                        <div class="progress progress-striped active" style="height: 35px;margin-top: 10px;color: #999999">
                                                            <div style="width: 60%;" class="bar"><h4>60%</h4></div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <h4>20/10/2018</h4>
                                                    </td>
                                                    <td><h4>23/12/2018</h4></td>
                                                    
                                                    <td class="center">
                                                        <a href="#myModal" data-toggle="modal" ><button class="btn" style="width: 100%"><i class="icon-eye-open"></i> Voire</button></a>
                                                        <button class="btn btn-danger" style="width: 100%"><i class="icon-remove icon-white"></i> Supprimer</button>
                                                    </td>
                                                </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- /block -->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left">Listes des comts</div>
                                </div>
                                <div class="block-content collapse in">
                                    <div class="span12">
                                        
                                        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                            <thead>
                                                <tr>
                                                    <th>Commit</th>
                                                    <th>Date</th>
                                                    
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr class="odd gradeX">
                                                    <td>Creation du projet ${ tableau.nomTableau }</td>
                                                    <td>18/01/2018</td>
                                                    
                                                </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="span12">
                            <div id="myModal" class="modal hide block" style="width: 60%;margin-left: unset;left: 20%;">
                                <div class="modal-header">
                                    <button data-dismiss="modal" class="close" type="button">&times;</button>
                                    <h3>Ajouter une nouvelle tache</h3>
                                </div>
                                <div class="modal-body block-content" style="max-height: 580px;">
                                    <div class="span12" >
                                        <span class="span8" >
                                            <h5><i class="fa fa-tasks" aria-hidden="true" style="color:#999" ></i> Titre</h5>
                                            <p style="width: 100%;" onclick="document.getElementById('titre').style.display='block';document.getElementById('but').style.display='block';this.style.display='none';">Titre de la tache..</p>
                                            <input id="titre" style="display: none;width: auto;" type="text" class="input-xlarge datepicker" id="date01" value="Titre de la tache">
                                            <h5><i class="fa fa-align-justify" aria-hidden="true" style="color:#999" ></i> Description</h5>
                                           <p style="width: 100%; height: 160px" onclick="document.getElementById('textAreaTask').style.display='block';document.getElementById('but').style.display='block';this.style.display='none';">Description du tache ... 
                                            </p>
                                            <textarea id="textAreaTask" class="" placeholder="Enter text ..." style="width: 100%; height: 160px;display: none;" >Description du tache ... 
                                            </textarea>
                                        </span>
                                        <span class="span4" style="float: right;">
                                            <div class="span6">
                                                <h5><i class="icon-time" aria-hidden="true" style="color:#999" ></i> Date Debut</h5>
                                                <p style="width: 100%;" onclick="document.getElementById('dateDebutTask').style.display='block';document.getElementById('but').style.display='block';this.style.display='none';">20/12/2018</p>
                                                <input id="dateDebutTask" style="display: none;width: 78%;" type="date" class="input-xlarge datepicker" id="date01" value="20/12/2018">
                                            </div>
                                            <div class="span6">
                                                <h5><i class="icon-time" aria-hidden="true" style="color:#999" ></i> Date Fin</h5>
                                                <p style="width: 100%;" onclick="document.getElementById('dateFinTask').style.display='block';document.getElementById('but').style.display='block';this.style.display='none';">20/12/2018</p>
                                                <input id="dateFinTask" style="display: none;width: 78%;" type="date" class="input-xlarge datepicker" id="date01" value="20/12/2018">
                                            </div>
                                            <div class="span10">
                                                <button type="button" class="btn btn-large btn-block" > <i class="fa fa-list" aria-hidden="true"  ></i> &nbsp;&nbsp;&nbsp;&nbsp;Ajouter checklist</button>
                                                
                                            </div>
                                        </span>
                                    </div>
                                    <span class="span4" id="but" style="float: right;display: none;">
                                        <input type="submit" class="btn btn-large btn-block" value='Enregistrer les modifications'/>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
			    </div>
			</div>
            
        </div>
        
        <script src="vendors/jquery-1.9.1.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="vendors/datatables/js/jquery.dataTables.min.js"></script>


        <script src="assets/scripts.js"></script>
        <script src="assets/DT_bootstrap.js"></script>
        <script>
        $(function() {
            
        });
        
        </script>
        
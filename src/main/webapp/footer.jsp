<%--
  Created by IntelliJ IDEA.
  User: Kimi John
  Date: 2018/5/17
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<footer>
    <div class="container">
        <div class="wrap-footer">
            <div class="row">
                <div class="col-md-3 col-footer footer-1">
                    <img src="images/logofooter.png" />
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                </div>
                <div class="col-md-3 col-footer footer-2">
                    <div class="heading"><h4>Customer Service</h4></div>
                    <ul>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Delivery Information</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms & Conditions</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </div>
                <div class="col-md-3 col-footer footer-3">
                    <div class="heading"><h4>My Account</h4></div>
                    <ul>
                        <li><a href="#">My Account</a></li>
                        <li><a href="#">Brands</a></li>
                        <li><a href="#">Gift Vouchers</a></li>
                        <li><a href="#">Specials</a></li>
                        <li><a href="#">Site Map</a></li>
                    </ul>
                </div>
                <div class="col-md-3 col-footer footer-4">
                    <div class="heading"><h4>Contact Us</h4></div>
                    <ul>
                        <li><span class="glyphicon glyphicon-home"></span>California, United States 3000009</li>
                        <li><span class="glyphicon glyphicon-earphone"></span>+91 8866888111</li>
                        <li><span class="glyphicon glyphicon-envelope"></span>infor@yoursite.com</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="copyright">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    Copyright &copy; 2018.Company hu All rights reserved.
                </div>
                <div class="col-md-6">
                    <div class="pull-right">
                        <ul>
                            <li><img src="images/visa-curved-32px.png" /></li>
                            <li><img src="images/paypal-curved-32px.png" /></li>
                            <li><img src="images/discover-curved-32px.png" /></li>
                            <li><img src="images/maestro-curved-32px.png" /></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>

<!-- IMG-thumb -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
    $(document).ready(function(){
        $(".nav-tabs a").click(function(){
            $(this).tab('show');
        });
        $('.nav-tabs a').on('shown.bs.tab', function(event){
            var x = $(event.target).text();         // active tab
            var y = $(event.relatedTarget).text();  // previous tab
            $(".act span").text(x);
            $(".prev span").text(y);
        });

        $("#score1").attr("disabled",false);
        $("#message").attr("disabled",false);
    });
</script>
<%--
<script>
    $(document).ready(function() {
        $("#score1").attr("disabled",false);
        $("#message").attr("disabled",false);


    });
</script>
--%>

<script>
    function changeCount()
    {
        var tempvar1 = parseInt(documentF.getElementById("inputcount").value);

        var tempvar = parseInt(document.getElementById("shoppingcount").innerHTML);
        // alert(tempvar1+tempvar);
        document.getElementById("shoppingcount").innerHTML=tempvar1+tempvar;
    }
</script>
</body>
</html>

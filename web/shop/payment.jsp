<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Payment Information</title>
        <link rel="stylesheet" href="../style/showdown.css" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <p><a href="<c:url value='http://localhost/showdown/show/list'/>"><img src="../images/showdown.jpg" alt="Showdown"/></a></p>
            <h1>Payment Information</h1>

            <form action="<c:url value='/cart/checkout' />" method="post">
                <fieldset><legend>Payment Details</legend>
                    <table>
                        <tr>
                            <td>Credit Card Type</td>
                            <td>
                                <input type="radio" name="cardType" id="visa" value="VISA" checked="checked" />
                                <label for="visa">VISA</label>
                                <input type="radio" name="cardType" id="mastercard" value="Mastercard" />
                                <label for="mastercard">Mastercard</label>
                                <input type="radio" name="cardType" id="discover" value="Discover" />
                                <label for="discover">Discover</label>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="cardNumber">Credit Card Number</label></td>
                            <td><input type="text" name="cardNumber" id="cardNumber" value=""/></td>
                        </tr>
                        <tr>
                            <td>Credit Card Expiration Date</td>
                            <td>
                                <select name="cardMonth">
                                    <option value="1">January</option>
                                    <option value="2">February</option>
                                    <option value="3">March</option>
                                    <option value="4">April</option>
                                    <option value="5">May</option>
                                    <option value="6">June</option>
                                    <option value="7">July</option>
                                    <option value="8">August</option>
                                    <option value="9">September</option>
                                    <option value="10">October</option>
                                    <option value="11">November</option>
                                    <option value="12">December</option>
                                </select>
                                <select name="cardYear">
                                    <option value="2009">2009</option>
                                    <option value="2010">2010</option>
                                    <option value="2011">2011</option>
                                    <option value="2012">2012</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="name">Billing Name</label></td>
                            <td><input id="name" name="name" type="text" /></td>
                        </tr>
                        <tr>
                            <td><label for="address">Address</label></td>
                            <td><input id="address" name="address" type="text" /></td>
                        </tr>
                        <tr>
                            <td><label for="city">City</label></td>
                            <td><input id="city" name="city" type="text" /></td>
                        </tr>
                        <tr>
                            <td><label for="state">State</label></td>
                            <td><input id="state" name="state" type="text" /></td>
                        </tr>
                        <tr>
                            <td><label for="zip">Zip Code</label></td>
                            <td><input id="zip" name="zip" type="text" /></td>
                        </tr>
                    </table>
                </fieldset>
                <p>
                    <input type="button" onclick="parent.location='http://localhost/showdown/cart/list'" value="Back to Cart" />
                    <input type="submit" value="Purchase" />
                </p>
            </form>

            <!-- footer -->
            <p id="footer">&copy; 2009, Ben Zoller</p>
        </div>
    </body>
</html>
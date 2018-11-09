<html>
<head>
        <#include "../common/header.ftl">
</head>
<body>
<div id="wrapper" class="toggled">

<#--边栏-->
            <#include "../common/nav.ftl">
<#--主要内容去-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-4 column">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>订单id</th>
                    <th>订单总金额</th>
                </tr>
                </thead>
                <tbody>
                    <tr class="success">
                        <td>${orderDTO.orderId}</td>
                        <td>${orderDTO.orderAmount}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <#--订单详情表-->
        <div class="col-md-12 column">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>商品id</th>
                    <th>商品名称</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>总额</th>
                </tr>
                </thead>
                <tbody>
                    <#list orderDTO.orderDetailList as detail>
                    <tr class="success">
                        <td>${detail.productId}</td>
                        <td>${detail.productName}</td>
                        <td>${detail.productPrice}</td>
                        <td>${detail.productQuantity}</td>
                        <td>${detail.productPrice * detail.productQuantity}</td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>
        <#if orderDTO.getOrderStatusEnum().code == 0>
        <div class="col-md-12 column">
            <a href="/sell/seller/order/finish?orderId=${orderDTO.orderId}" type="button" class="btn btn-primary btn-lg">完结订单</a>
            <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}" type="button" class="btn btn-lg btn-danger">取消订单</a>
        </div>
        </#if>
    </div>
</div>
    </div>
</body>
</html>
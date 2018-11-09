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
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>商品id</th>
                                <th>名称</th>
                                <th>图片</th>
                                <th>单价</th>
                                <th>库存</th>
                                <th>描述</th>
                                <th>类目</th>
                                <th>创建时间</th>
                                <th>修改时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                    <#list productPage.content as product>
                    <tr class="success">
                        <td>${product.productId}</td>
                        <td>${product.productName}</td>
                        <td><img width="100" height="100" src="${product.productIcon}" alt="商品图片"></td>
                        <td>${product.productPrice}</td>
                        <td>${product.productStock}</td>
                        <td>${product.productDescription}</td>
                        <td>${product.categoryType}</td>
                        <td>${product.createTime}</td>
                        <td>${product.updateTime}</td>
                        <td>
                            <a href="/sell/seller/product/update?productId=${product.productId}">修改</a>
                            <#if product.productStatusEnum.code == 0>
                                <a href="/sell/seller/product/off_sale?productId=${product.productId}">下架</a>
                            <#else>
                                <a href="/sell/seller/product/on_sale?productId=${product.productId}">上架</a>
                            </#if>
                        </td>
                    </tr>
                    </#list>
                            </tbody>
                        </table>
                    </div>
                <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/sell/seller/product/list?page=${currentPage - 1}&size=${size}"">上一页</a></li>
                    </#if>
                    <#list 1..productPage.getTotalPages() as page>
                        <#if currentPage == page>
                        <li class="disabled"><a href="/sell/seller/product/list?page=${page}&size=${size}">${page}</a></li>
                        <#else>
                        <li><a href="/sell/seller/product/list?page=${page}&size=${size}">${page}</a></li>
                        </#if>
                    </#list>
                    <#if currentPage gte productPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/sell/seller/product/list?page=${currentPage + 1}&size=${size}"">上一页</a></li>
                    </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>
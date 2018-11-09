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
            <div class="col-md-4 column">
                <form role="form" method="post" action="/sell/seller/category/save">
                    <div class="form-group">
                        <label>名称</label><input type="text" name="productName" class="form-control" value="${(category.categoryName)!""}"/>
                    </div>
                    <div class="form-group">
                        <label>type</label><input type="number" name="productPrice" class="form-control" value="${(category.categoryType)!""}"/>
                    </div>
                    <div class="form-group">s
                        <input hidden type="text" name="categoryId" value="${(category.categoryId)!""}" />
                    </div>
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
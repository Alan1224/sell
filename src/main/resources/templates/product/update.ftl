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
                <form role="form" method="post" action="/sell/seller/product/save">
                    <div class="form-group">
                        <label for="exampleInputEmail1">名称</label><input type="text" name="productName" class="form-control" value="${(productInfo.productName)!""}"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">价格</label><input type="text" name="productPrice" class="form-control" value="${(productInfo.productPrice)!""}"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">库存</label><input type="number" name="productStock" class="form-control" value="${(productInfo.productStock)!""}"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">描述</label><input type="text" name="productDescription" class="form-control" value="${(productInfo.productDescription)!""}"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">图片</label>
                        <img width="200" height="200" src="${(productInfo.productIcon)!""}" alt="商品图片展示">
                        <input name="productIcon" class="form-control" value="${(productInfo.productIcon)!""}"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">类目</label>
                        <select name="categoryType" class="form-control">
                            <#list categoryList as catgory>
                                <option value="${catgory.categoryType}"
                                        <#if (productInfo.categoryType)?? && productInfo.categoryType == catgory.categoryType>
                                            selected
                                        </#if>
                                    >${catgory.categoryName}
                                </option>
                            </#list>
                        </select>
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!""}" />
                    </div>
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
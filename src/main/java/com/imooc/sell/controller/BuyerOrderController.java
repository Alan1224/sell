package com.imooc.sell.controller;

import antlr.StringUtils;
import com.imooc.sell.Utils.ResultVOUtil;
import com.imooc.sell.VO.ResultVO;
import com.imooc.sell.converter.OrderForm2OrderDTOConverter;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.form.OrderForm;
import com.imooc.sell.service.BuyerService;
import com.imooc.sell.service.OrderService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.text.CollatorUtilities;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 2018/11/4 16:54
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;
    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("[表单校验]参数不正确,orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);

        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("[创建订单]购物车不能为空",orderForm);
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO orderDTOResult = orderService.create(orderDTO);

        Map<String ,String > map = new HashMap<>();
        map.put("orderId",orderDTOResult.getOrderId());
        return ResultVOUtil.success(map);
    }
    //订单列表
    @RequestMapping("list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){
        if (org.springframework.util.StringUtils.isEmpty(openid)){
            log.error("[查询订单列表]openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = new PageRequest(page,size);
        Page<OrderDTO> orderDTOS = orderService.findList(openid,pageRequest);

        return ResultVOUtil.success(orderDTOS.getContent());
    }
    //订单详情
    @GetMapping("detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                         @RequestParam("orderId") String orderId){
        if (org.springframework.util.StringUtils.isEmpty(openid)){
            log.error("[查询订单详情]openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        if (org.springframework.util.StringUtils.isEmpty(orderId)){
            log.error("[查询订单详情]orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        return ResultVOUtil.success(buyerService.findOrderOne(openid,orderId));
    }
    //订单取消
    @PostMapping("cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){
        if (org.springframework.util.StringUtils.isEmpty(openid)){
            log.error("[查询订单详情]openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        if (org.springframework.util.StringUtils.isEmpty(orderId)){
            log.error("[查询订单详情]orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        buyerService.cancerOrder(openid, orderId);
        return ResultVOUtil.success();
    }
}
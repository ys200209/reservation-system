package com.ys200209.reservationsystem.domain.product.utils;

public class ProductSQLMapper {
    public static final String SELECT_PRODUCT_IMAGES =
            "SELECT pi.product_id productId,pi.id productImageId, pi.type type, pi.file_id fileInfoId, fi.file_name fileName, fi.save_file_name saveFileName, fi.content_type contentType, fi.delete_flag deleteFlag, fi.create_date createDate, fi.modify_date modifyDate\n"
            + "FROM product_image pi, file_info fi\n"
            + "WHERE pi.file_id = fi.id AND pi.type = 'ma' AND pi.product_id = (\n"
            + "    SELECT di.product_id\n"
            + "    FROM display_info di\n"
            + "    WHERE di.id = ?\n"
            + ");";

    public static final String SELECT_PRODUCT_PRICES =
            "SELECT pp.id id, pp.product_id productId, pp.price_type_name priceTypeName, pp.price price, pp.discount_rate discountRate, pp.create_date createDate, pp.modify_date modifyDate\n"
            + "FROM product_price pp, display_info di\n"
            + "WHERE pp.product_id = di.product_id AND di.id = ?";
}

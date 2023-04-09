package com.ys200209.reservationsystem.domain.display.utils;

public class DisplayInfoSQLMapper {
    public static final String SELECT_DISPLAY_INFOS_QUERY =
            "SELECT p.id, p.category_id categoryId, di.id displayInfoId, c.name, p.description, p.content, p.event, di.opening_hours openingHours, di.place_name placeName, di.place_lot placeLot, di.place_street placeStreet, di.tel, di.homepage, di.email, di.create_date createDate, di.modify_date modifyDate, "
                    + "    ("
                    + "        SELECT fi.id "
                    + "        FROM product_image pi, file_info fi "
                    + "        WHERE pi.file_id = fi.id and pi.product_id = p.id and fi.file_name LIKE CONCAT('%', 'ma' '%') "
                    + "    ) as fileId "
                    + "FROM product p, display_info di, category c "
                    + "WHERE p.id = di.product_id and p.category_id = c.id and p.category_id = ?";

    public static final String SELECT_DISPLAY_INFO_QUERY =
            "SELECT p.id, p.category_id categoryId, di.id displayInfoId, c.name, p.description, p.content, p.event, di.opening_hours openingHours, di.place_name placeName, di.place_lot placeLot, di.place_street placeStreet, di.tel, di.homepage, di.email, di.create_date createDate, di.modify_date modifyDate,\n"
                    + "    (\n"
                    + "        SELECT fi.id\n"
                    + "        FROM product_image pi, file_info fi\n"
                    + "        WHERE pi.file_id = fi.id and pi.product_id = p.id and fi.file_name LIKE CONCAT('%', 'ma' '%')\n"
                    + "    ) as fileId\n"
                    + "FROM product p, display_info di, category c\n"
                    + "WHERE p.id = di.product_id and p.category_id = c.id and di.id = ?";

    public static final String SELECT_DISPLAY_INFO_IMAGES =
            "SELECT dii.id id, dii.display_info_id displayInfoId, fi.id fileId, fi.file_name fileName, fi.save_file_name saveFileName, fi.content_type contentType, fi.delete_flag deleteFlag, fi.create_date createDate, fi.modify_date modifyDate\n"
            + "FROM display_info_image dii, file_info fi\n"
            + "WHERE dii.file_id = fi.id AND dii.display_info_id = ?";
}

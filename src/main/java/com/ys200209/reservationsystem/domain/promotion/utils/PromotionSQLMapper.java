package com.ys200209.reservationsystem.domain.promotion.utils;

public class PromotionSQLMapper {
    public static final String SELECT_PROMOTIONS_QUERY =
            "SELECT pm.id id, pd.id productId, pd.category_id categoryId, c.name categoryName, pd.description,\n"
                    + "       (\n"
                    + "           SELECT fi.id\n"
                    + "           FROM product_image pi, file_info fi\n"
                    + "           WHERE pi.file_id = fi.id and pi.product_id = pd.id and fi.file_name LIKE CONCAT('%', 'ma' '%')\n"
                    + "       ) as fileId\n"
                    + "FROM promotion pm, product pd, category c\n"
                    + "WHERE pd.id = pm.product_id AND pd.category_id = c.id";
}

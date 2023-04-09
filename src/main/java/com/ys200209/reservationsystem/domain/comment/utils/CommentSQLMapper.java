package com.ys200209.reservationsystem.domain.comment.utils;

public class CommentSQLMapper {
    public static final String SELECT_COMMENTS_AVERAGE_SCORE =
            "SELECT AVG(score) avgScore\n"
            + "FROM reservation_user_comment ruc, product p, display_info di\n"
            + "WHERE p.id = ruc.product_id AND p.id = di.product_id AND di.id = ?";
}

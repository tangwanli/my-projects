package com.ros.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOrderSitIdIsNull() {
            addCriterion("order_sit_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderSitIdIsNotNull() {
            addCriterion("order_sit_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSitIdEqualTo(Integer value) {
            addCriterion("order_sit_id =", value, "orderSitId");
            return (Criteria) this;
        }

        public Criteria andOrderSitIdNotEqualTo(Integer value) {
            addCriterion("order_sit_id <>", value, "orderSitId");
            return (Criteria) this;
        }

        public Criteria andOrderSitIdGreaterThan(Integer value) {
            addCriterion("order_sit_id >", value, "orderSitId");
            return (Criteria) this;
        }

        public Criteria andOrderSitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_sit_id >=", value, "orderSitId");
            return (Criteria) this;
        }

        public Criteria andOrderSitIdLessThan(Integer value) {
            addCriterion("order_sit_id <", value, "orderSitId");
            return (Criteria) this;
        }

        public Criteria andOrderSitIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_sit_id <=", value, "orderSitId");
            return (Criteria) this;
        }

        public Criteria andOrderSitIdIn(List<Integer> values) {
            addCriterion("order_sit_id in", values, "orderSitId");
            return (Criteria) this;
        }

        public Criteria andOrderSitIdNotIn(List<Integer> values) {
            addCriterion("order_sit_id not in", values, "orderSitId");
            return (Criteria) this;
        }

        public Criteria andOrderSitIdBetween(Integer value1, Integer value2) {
            addCriterion("order_sit_id between", value1, value2, "orderSitId");
            return (Criteria) this;
        }

        public Criteria andOrderSitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_sit_id not between", value1, value2, "orderSitId");
            return (Criteria) this;
        }

        public Criteria andOrderFoodIdIsNull() {
            addCriterion("order_food_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderFoodIdIsNotNull() {
            addCriterion("order_food_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFoodIdEqualTo(String value) {
            addCriterion("order_food_id =", value, "orderFoodId");
            return (Criteria) this;
        }

        public Criteria andOrderFoodIdNotEqualTo(String value) {
            addCriterion("order_food_id <>", value, "orderFoodId");
            return (Criteria) this;
        }

        public Criteria andOrderFoodIdGreaterThan(String value) {
            addCriterion("order_food_id >", value, "orderFoodId");
            return (Criteria) this;
        }

        public Criteria andOrderFoodIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_food_id >=", value, "orderFoodId");
            return (Criteria) this;
        }

        public Criteria andOrderFoodIdLessThan(String value) {
            addCriterion("order_food_id <", value, "orderFoodId");
            return (Criteria) this;
        }

        public Criteria andOrderFoodIdLessThanOrEqualTo(String value) {
            addCriterion("order_food_id <=", value, "orderFoodId");
            return (Criteria) this;
        }

        public Criteria andOrderFoodIdLike(String value) {
            addCriterion("order_food_id like", value, "orderFoodId");
            return (Criteria) this;
        }

        public Criteria andOrderFoodIdNotLike(String value) {
            addCriterion("order_food_id not like", value, "orderFoodId");
            return (Criteria) this;
        }

        public Criteria andOrderFoodIdIn(List<String> values) {
            addCriterion("order_food_id in", values, "orderFoodId");
            return (Criteria) this;
        }

        public Criteria andOrderFoodIdNotIn(List<String> values) {
            addCriterion("order_food_id not in", values, "orderFoodId");
            return (Criteria) this;
        }

        public Criteria andOrderFoodIdBetween(String value1, String value2) {
            addCriterion("order_food_id between", value1, value2, "orderFoodId");
            return (Criteria) this;
        }

        public Criteria andOrderFoodIdNotBetween(String value1, String value2) {
            addCriterion("order_food_id not between", value1, value2, "orderFoodId");
            return (Criteria) this;
        }

        public Criteria andOrderFoodPriceIsNull() {
            addCriterion("order_food_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderFoodPriceIsNotNull() {
            addCriterion("order_food_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFoodPriceEqualTo(Integer value) {
            addCriterion("order_food_price =", value, "orderFoodPrice");
            return (Criteria) this;
        }

        public Criteria andOrderFoodPriceNotEqualTo(Integer value) {
            addCriterion("order_food_price <>", value, "orderFoodPrice");
            return (Criteria) this;
        }

        public Criteria andOrderFoodPriceGreaterThan(Integer value) {
            addCriterion("order_food_price >", value, "orderFoodPrice");
            return (Criteria) this;
        }

        public Criteria andOrderFoodPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_food_price >=", value, "orderFoodPrice");
            return (Criteria) this;
        }

        public Criteria andOrderFoodPriceLessThan(Integer value) {
            addCriterion("order_food_price <", value, "orderFoodPrice");
            return (Criteria) this;
        }

        public Criteria andOrderFoodPriceLessThanOrEqualTo(Integer value) {
            addCriterion("order_food_price <=", value, "orderFoodPrice");
            return (Criteria) this;
        }

        public Criteria andOrderFoodPriceIn(List<Integer> values) {
            addCriterion("order_food_price in", values, "orderFoodPrice");
            return (Criteria) this;
        }

        public Criteria andOrderFoodPriceNotIn(List<Integer> values) {
            addCriterion("order_food_price not in", values, "orderFoodPrice");
            return (Criteria) this;
        }

        public Criteria andOrderFoodPriceBetween(Integer value1, Integer value2) {
            addCriterion("order_food_price between", value1, value2, "orderFoodPrice");
            return (Criteria) this;
        }

        public Criteria andOrderFoodPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("order_food_price not between", value1, value2, "orderFoodPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOderFinishtimeIsNull() {
            addCriterion("oder_finishtime is null");
            return (Criteria) this;
        }

        public Criteria andOderFinishtimeIsNotNull() {
            addCriterion("oder_finishtime is not null");
            return (Criteria) this;
        }

        public Criteria andOderFinishtimeEqualTo(Date value) {
            addCriterion("oder_finishtime =", value, "oderFinishtime");
            return (Criteria) this;
        }

        public Criteria andOderFinishtimeNotEqualTo(Date value) {
            addCriterion("oder_finishtime <>", value, "oderFinishtime");
            return (Criteria) this;
        }

        public Criteria andOderFinishtimeGreaterThan(Date value) {
            addCriterion("oder_finishtime >", value, "oderFinishtime");
            return (Criteria) this;
        }

        public Criteria andOderFinishtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oder_finishtime >=", value, "oderFinishtime");
            return (Criteria) this;
        }

        public Criteria andOderFinishtimeLessThan(Date value) {
            addCriterion("oder_finishtime <", value, "oderFinishtime");
            return (Criteria) this;
        }

        public Criteria andOderFinishtimeLessThanOrEqualTo(Date value) {
            addCriterion("oder_finishtime <=", value, "oderFinishtime");
            return (Criteria) this;
        }

        public Criteria andOderFinishtimeIn(List<Date> values) {
            addCriterion("oder_finishtime in", values, "oderFinishtime");
            return (Criteria) this;
        }

        public Criteria andOderFinishtimeNotIn(List<Date> values) {
            addCriterion("oder_finishtime not in", values, "oderFinishtime");
            return (Criteria) this;
        }

        public Criteria andOderFinishtimeBetween(Date value1, Date value2) {
            addCriterion("oder_finishtime between", value1, value2, "oderFinishtime");
            return (Criteria) this;
        }

        public Criteria andOderFinishtimeNotBetween(Date value1, Date value2) {
            addCriterion("oder_finishtime not between", value1, value2, "oderFinishtime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
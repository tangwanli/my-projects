package com.ros.bean;

import java.util.ArrayList;
import java.util.List;

public class FoodtypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FoodtypeExample() {
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

        public Criteria andFoodtypeIdIsNull() {
            addCriterion("foodtype_id is null");
            return (Criteria) this;
        }

        public Criteria andFoodtypeIdIsNotNull() {
            addCriterion("foodtype_id is not null");
            return (Criteria) this;
        }

        public Criteria andFoodtypeIdEqualTo(Integer value) {
            addCriterion("foodtype_id =", value, "foodtypeId");
            return (Criteria) this;
        }

        public Criteria andFoodtypeIdNotEqualTo(Integer value) {
            addCriterion("foodtype_id <>", value, "foodtypeId");
            return (Criteria) this;
        }

        public Criteria andFoodtypeIdGreaterThan(Integer value) {
            addCriterion("foodtype_id >", value, "foodtypeId");
            return (Criteria) this;
        }

        public Criteria andFoodtypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("foodtype_id >=", value, "foodtypeId");
            return (Criteria) this;
        }

        public Criteria andFoodtypeIdLessThan(Integer value) {
            addCriterion("foodtype_id <", value, "foodtypeId");
            return (Criteria) this;
        }

        public Criteria andFoodtypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("foodtype_id <=", value, "foodtypeId");
            return (Criteria) this;
        }

        public Criteria andFoodtypeIdIn(List<Integer> values) {
            addCriterion("foodtype_id in", values, "foodtypeId");
            return (Criteria) this;
        }

        public Criteria andFoodtypeIdNotIn(List<Integer> values) {
            addCriterion("foodtype_id not in", values, "foodtypeId");
            return (Criteria) this;
        }

        public Criteria andFoodtypeIdBetween(Integer value1, Integer value2) {
            addCriterion("foodtype_id between", value1, value2, "foodtypeId");
            return (Criteria) this;
        }

        public Criteria andFoodtypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("foodtype_id not between", value1, value2, "foodtypeId");
            return (Criteria) this;
        }

        public Criteria andFoodtypeNameIsNull() {
            addCriterion("foodtype_name is null");
            return (Criteria) this;
        }

        public Criteria andFoodtypeNameIsNotNull() {
            addCriterion("foodtype_name is not null");
            return (Criteria) this;
        }

        public Criteria andFoodtypeNameEqualTo(String value) {
            addCriterion("foodtype_name =", value, "foodtypeName");
            return (Criteria) this;
        }

        public Criteria andFoodtypeNameNotEqualTo(String value) {
            addCriterion("foodtype_name <>", value, "foodtypeName");
            return (Criteria) this;
        }

        public Criteria andFoodtypeNameGreaterThan(String value) {
            addCriterion("foodtype_name >", value, "foodtypeName");
            return (Criteria) this;
        }

        public Criteria andFoodtypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("foodtype_name >=", value, "foodtypeName");
            return (Criteria) this;
        }

        public Criteria andFoodtypeNameLessThan(String value) {
            addCriterion("foodtype_name <", value, "foodtypeName");
            return (Criteria) this;
        }

        public Criteria andFoodtypeNameLessThanOrEqualTo(String value) {
            addCriterion("foodtype_name <=", value, "foodtypeName");
            return (Criteria) this;
        }

        public Criteria andFoodtypeNameLike(String value) {
            addCriterion("foodtype_name like", value, "foodtypeName");
            return (Criteria) this;
        }

        public Criteria andFoodtypeNameNotLike(String value) {
            addCriterion("foodtype_name not like", value, "foodtypeName");
            return (Criteria) this;
        }

        public Criteria andFoodtypeNameIn(List<String> values) {
            addCriterion("foodtype_name in", values, "foodtypeName");
            return (Criteria) this;
        }

        public Criteria andFoodtypeNameNotIn(List<String> values) {
            addCriterion("foodtype_name not in", values, "foodtypeName");
            return (Criteria) this;
        }

        public Criteria andFoodtypeNameBetween(String value1, String value2) {
            addCriterion("foodtype_name between", value1, value2, "foodtypeName");
            return (Criteria) this;
        }

        public Criteria andFoodtypeNameNotBetween(String value1, String value2) {
            addCriterion("foodtype_name not between", value1, value2, "foodtypeName");
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
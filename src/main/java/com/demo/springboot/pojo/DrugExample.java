package com.demo.springboot.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrugExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugExample() {
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

        public Criteria andDrugsIdIsNull() {
            addCriterion("drugs_Id is null");
            return (Criteria) this;
        }

        public Criteria andDrugsIdIsNotNull() {
            addCriterion("drugs_Id is not null");
            return (Criteria) this;
        }

        public Criteria andDrugsIdEqualTo(Integer value) {
            addCriterion("drugs_Id =", value, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdNotEqualTo(Integer value) {
            addCriterion("drugs_Id <>", value, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdGreaterThan(Integer value) {
            addCriterion("drugs_Id >", value, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("drugs_Id >=", value, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdLessThan(Integer value) {
            addCriterion("drugs_Id <", value, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdLessThanOrEqualTo(Integer value) {
            addCriterion("drugs_Id <=", value, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdIn(List<Integer> values) {
            addCriterion("drugs_Id in", values, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdNotIn(List<Integer> values) {
            addCriterion("drugs_Id not in", values, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdBetween(Integer value1, Integer value2) {
            addCriterion("drugs_Id between", value1, value2, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrugsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("drugs_Id not between", value1, value2, "drugsId");
            return (Criteria) this;
        }

        public Criteria andDrNameIsNull() {
            addCriterion("dr_Name is null");
            return (Criteria) this;
        }

        public Criteria andDrNameIsNotNull() {
            addCriterion("dr_Name is not null");
            return (Criteria) this;
        }

        public Criteria andDrNameEqualTo(String value) {
            addCriterion("dr_Name =", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameNotEqualTo(String value) {
            addCriterion("dr_Name <>", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameGreaterThan(String value) {
            addCriterion("dr_Name >", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameGreaterThanOrEqualTo(String value) {
            addCriterion("dr_Name >=", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameLessThan(String value) {
            addCriterion("dr_Name <", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameLessThanOrEqualTo(String value) {
            addCriterion("dr_Name <=", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameLike(String value) {
            addCriterion("dr_Name like", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameNotLike(String value) {
            addCriterion("dr_Name not like", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameIn(List<String> values) {
            addCriterion("dr_Name in", values, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameNotIn(List<String> values) {
            addCriterion("dr_Name not in", values, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameBetween(String value1, String value2) {
            addCriterion("dr_Name between", value1, value2, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameNotBetween(String value1, String value2) {
            addCriterion("dr_Name not between", value1, value2, "drName");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andImagesIsNull() {
            addCriterion("images is null");
            return (Criteria) this;
        }

        public Criteria andImagesIsNotNull() {
            addCriterion("images is not null");
            return (Criteria) this;
        }

        public Criteria andImagesEqualTo(String value) {
            addCriterion("images =", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotEqualTo(String value) {
            addCriterion("images <>", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThan(String value) {
            addCriterion("images >", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThanOrEqualTo(String value) {
            addCriterion("images >=", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLessThan(String value) {
            addCriterion("images <", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLessThanOrEqualTo(String value) {
            addCriterion("images <=", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLike(String value) {
            addCriterion("images like", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotLike(String value) {
            addCriterion("images not like", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesIn(List<String> values) {
            addCriterion("images in", values, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotIn(List<String> values) {
            addCriterion("images not in", values, "images");
            return (Criteria) this;
        }

        public Criteria andImagesBetween(String value1, String value2) {
            addCriterion("images between", value1, value2, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotBetween(String value1, String value2) {
            addCriterion("images not between", value1, value2, "images");
            return (Criteria) this;
        }

        public Criteria andDrInfoIsNull() {
            addCriterion("dr_Info is null");
            return (Criteria) this;
        }

        public Criteria andDrInfoIsNotNull() {
            addCriterion("dr_Info is not null");
            return (Criteria) this;
        }

        public Criteria andDrInfoEqualTo(String value) {
            addCriterion("dr_Info =", value, "drInfo");
            return (Criteria) this;
        }

        public Criteria andDrInfoNotEqualTo(String value) {
            addCriterion("dr_Info <>", value, "drInfo");
            return (Criteria) this;
        }

        public Criteria andDrInfoGreaterThan(String value) {
            addCriterion("dr_Info >", value, "drInfo");
            return (Criteria) this;
        }

        public Criteria andDrInfoGreaterThanOrEqualTo(String value) {
            addCriterion("dr_Info >=", value, "drInfo");
            return (Criteria) this;
        }

        public Criteria andDrInfoLessThan(String value) {
            addCriterion("dr_Info <", value, "drInfo");
            return (Criteria) this;
        }

        public Criteria andDrInfoLessThanOrEqualTo(String value) {
            addCriterion("dr_Info <=", value, "drInfo");
            return (Criteria) this;
        }

        public Criteria andDrInfoLike(String value) {
            addCriterion("dr_Info like", value, "drInfo");
            return (Criteria) this;
        }

        public Criteria andDrInfoNotLike(String value) {
            addCriterion("dr_Info not like", value, "drInfo");
            return (Criteria) this;
        }

        public Criteria andDrInfoIn(List<String> values) {
            addCriterion("dr_Info in", values, "drInfo");
            return (Criteria) this;
        }

        public Criteria andDrInfoNotIn(List<String> values) {
            addCriterion("dr_Info not in", values, "drInfo");
            return (Criteria) this;
        }

        public Criteria andDrInfoBetween(String value1, String value2) {
            addCriterion("dr_Info between", value1, value2, "drInfo");
            return (Criteria) this;
        }

        public Criteria andDrInfoNotBetween(String value1, String value2) {
            addCriterion("dr_Info not between", value1, value2, "drInfo");
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
package com.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoticeExample() {
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

        public Criteria andNoidIsNull() {
            addCriterion("Noid is null");
            return (Criteria) this;
        }

        public Criteria andNoidIsNotNull() {
            addCriterion("Noid is not null");
            return (Criteria) this;
        }

        public Criteria andNoidEqualTo(Integer value) {
            addCriterion("Noid =", value, "noid");
            return (Criteria) this;
        }

        public Criteria andNoidNotEqualTo(Integer value) {
            addCriterion("Noid <>", value, "noid");
            return (Criteria) this;
        }

        public Criteria andNoidGreaterThan(Integer value) {
            addCriterion("Noid >", value, "noid");
            return (Criteria) this;
        }

        public Criteria andNoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Noid >=", value, "noid");
            return (Criteria) this;
        }

        public Criteria andNoidLessThan(Integer value) {
            addCriterion("Noid <", value, "noid");
            return (Criteria) this;
        }

        public Criteria andNoidLessThanOrEqualTo(Integer value) {
            addCriterion("Noid <=", value, "noid");
            return (Criteria) this;
        }

        public Criteria andNoidIn(List<Integer> values) {
            addCriterion("Noid in", values, "noid");
            return (Criteria) this;
        }

        public Criteria andNoidNotIn(List<Integer> values) {
            addCriterion("Noid not in", values, "noid");
            return (Criteria) this;
        }

        public Criteria andNoidBetween(Integer value1, Integer value2) {
            addCriterion("Noid between", value1, value2, "noid");
            return (Criteria) this;
        }

        public Criteria andNoidNotBetween(Integer value1, Integer value2) {
            addCriterion("Noid not between", value1, value2, "noid");
            return (Criteria) this;
        }

        public Criteria andNonameIsNull() {
            addCriterion("NoName is null");
            return (Criteria) this;
        }

        public Criteria andNonameIsNotNull() {
            addCriterion("NoName is not null");
            return (Criteria) this;
        }

        public Criteria andNonameEqualTo(String value) {
            addCriterion("NoName =", value, "noname");
            return (Criteria) this;
        }

        public Criteria andNonameNotEqualTo(String value) {
            addCriterion("NoName <>", value, "noname");
            return (Criteria) this;
        }

        public Criteria andNonameGreaterThan(String value) {
            addCriterion("NoName >", value, "noname");
            return (Criteria) this;
        }

        public Criteria andNonameGreaterThanOrEqualTo(String value) {
            addCriterion("NoName >=", value, "noname");
            return (Criteria) this;
        }

        public Criteria andNonameLessThan(String value) {
            addCriterion("NoName <", value, "noname");
            return (Criteria) this;
        }

        public Criteria andNonameLessThanOrEqualTo(String value) {
            addCriterion("NoName <=", value, "noname");
            return (Criteria) this;
        }

        public Criteria andNonameLike(String value) {
            addCriterion("NoName like", value, "noname");
            return (Criteria) this;
        }

        public Criteria andNonameNotLike(String value) {
            addCriterion("NoName not like", value, "noname");
            return (Criteria) this;
        }

        public Criteria andNonameIn(List<String> values) {
            addCriterion("NoName in", values, "noname");
            return (Criteria) this;
        }

        public Criteria andNonameNotIn(List<String> values) {
            addCriterion("NoName not in", values, "noname");
            return (Criteria) this;
        }

        public Criteria andNonameBetween(String value1, String value2) {
            addCriterion("NoName between", value1, value2, "noname");
            return (Criteria) this;
        }

        public Criteria andNonameNotBetween(String value1, String value2) {
            addCriterion("NoName not between", value1, value2, "noname");
            return (Criteria) this;
        }

        public Criteria andNotimeIsNull() {
            addCriterion("NoTime is null");
            return (Criteria) this;
        }

        public Criteria andNotimeIsNotNull() {
            addCriterion("NoTime is not null");
            return (Criteria) this;
        }

        public Criteria andNotimeEqualTo(Date value) {
            addCriterion("NoTime =", value, "notime");
            return (Criteria) this;
        }

        public Criteria andNotimeNotEqualTo(Date value) {
            addCriterion("NoTime <>", value, "notime");
            return (Criteria) this;
        }

        public Criteria andNotimeGreaterThan(Date value) {
            addCriterion("NoTime >", value, "notime");
            return (Criteria) this;
        }

        public Criteria andNotimeGreaterThanOrEqualTo(Date value) {
            addCriterion("NoTime >=", value, "notime");
            return (Criteria) this;
        }

        public Criteria andNotimeLessThan(Date value) {
            addCriterion("NoTime <", value, "notime");
            return (Criteria) this;
        }

        public Criteria andNotimeLessThanOrEqualTo(Date value) {
            addCriterion("NoTime <=", value, "notime");
            return (Criteria) this;
        }

        public Criteria andNotimeIn(List<Date> values) {
            addCriterion("NoTime in", values, "notime");
            return (Criteria) this;
        }

        public Criteria andNotimeNotIn(List<Date> values) {
            addCriterion("NoTime not in", values, "notime");
            return (Criteria) this;
        }

        public Criteria andNotimeBetween(Date value1, Date value2) {
            addCriterion("NoTime between", value1, value2, "notime");
            return (Criteria) this;
        }

        public Criteria andNotimeNotBetween(Date value1, Date value2) {
            addCriterion("NoTime not between", value1, value2, "notime");
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
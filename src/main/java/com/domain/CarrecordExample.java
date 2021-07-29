package com.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarrecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarrecordExample() {
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

        public Criteria andRidIsNull() {
            addCriterion("RID is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("RID is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("RID =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("RID <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("RID >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("RID >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("RID <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("RID <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("RID in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("RID not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("RID between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("RID not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andCarnumberIsNull() {
            addCriterion("CarNumber is null");
            return (Criteria) this;
        }

        public Criteria andCarnumberIsNotNull() {
            addCriterion("CarNumber is not null");
            return (Criteria) this;
        }

        public Criteria andCarnumberEqualTo(String value) {
            addCriterion("CarNumber =", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotEqualTo(String value) {
            addCriterion("CarNumber <>", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberGreaterThan(String value) {
            addCriterion("CarNumber >", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberGreaterThanOrEqualTo(String value) {
            addCriterion("CarNumber >=", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberLessThan(String value) {
            addCriterion("CarNumber <", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberLessThanOrEqualTo(String value) {
            addCriterion("CarNumber <=", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberLike(String value) {
            addCriterion("CarNumber like", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotLike(String value) {
            addCriterion("CarNumber not like", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberIn(List<String> values) {
            addCriterion("CarNumber in", values, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotIn(List<String> values) {
            addCriterion("CarNumber not in", values, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberBetween(String value1, String value2) {
            addCriterion("CarNumber between", value1, value2, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotBetween(String value1, String value2) {
            addCriterion("CarNumber not between", value1, value2, "carnumber");
            return (Criteria) this;
        }

        public Criteria andParkpriceIsNull() {
            addCriterion("ParkPrice is null");
            return (Criteria) this;
        }

        public Criteria andParkpriceIsNotNull() {
            addCriterion("ParkPrice is not null");
            return (Criteria) this;
        }

        public Criteria andParkpriceEqualTo(String value) {
            addCriterion("ParkPrice =", value, "parkprice");
            return (Criteria) this;
        }

        public Criteria andParkpriceNotEqualTo(String value) {
            addCriterion("ParkPrice <>", value, "parkprice");
            return (Criteria) this;
        }

        public Criteria andParkpriceGreaterThan(String value) {
            addCriterion("ParkPrice >", value, "parkprice");
            return (Criteria) this;
        }

        public Criteria andParkpriceGreaterThanOrEqualTo(String value) {
            addCriterion("ParkPrice >=", value, "parkprice");
            return (Criteria) this;
        }

        public Criteria andParkpriceLessThan(String value) {
            addCriterion("ParkPrice <", value, "parkprice");
            return (Criteria) this;
        }

        public Criteria andParkpriceLessThanOrEqualTo(String value) {
            addCriterion("ParkPrice <=", value, "parkprice");
            return (Criteria) this;
        }

        public Criteria andParkpriceLike(String value) {
            addCriterion("ParkPrice like", value, "parkprice");
            return (Criteria) this;
        }

        public Criteria andParkpriceNotLike(String value) {
            addCriterion("ParkPrice not like", value, "parkprice");
            return (Criteria) this;
        }

        public Criteria andParkpriceIn(List<String> values) {
            addCriterion("ParkPrice in", values, "parkprice");
            return (Criteria) this;
        }

        public Criteria andParkpriceNotIn(List<String> values) {
            addCriterion("ParkPrice not in", values, "parkprice");
            return (Criteria) this;
        }

        public Criteria andParkpriceBetween(String value1, String value2) {
            addCriterion("ParkPrice between", value1, value2, "parkprice");
            return (Criteria) this;
        }

        public Criteria andParkpriceNotBetween(String value1, String value2) {
            addCriterion("ParkPrice not between", value1, value2, "parkprice");
            return (Criteria) this;
        }

        public Criteria andIntimeIsNull() {
            addCriterion("InTime is null");
            return (Criteria) this;
        }

        public Criteria andIntimeIsNotNull() {
            addCriterion("InTime is not null");
            return (Criteria) this;
        }

        public Criteria andIntimeEqualTo(Date value) {
            addCriterion("InTime =", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotEqualTo(Date value) {
            addCriterion("InTime <>", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThan(Date value) {
            addCriterion("InTime >", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("InTime >=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThan(Date value) {
            addCriterion("InTime <", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThanOrEqualTo(Date value) {
            addCriterion("InTime <=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeIn(List<Date> values) {
            addCriterion("InTime in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotIn(List<Date> values) {
            addCriterion("InTime not in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeBetween(Date value1, Date value2) {
            addCriterion("InTime between", value1, value2, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotBetween(Date value1, Date value2) {
            addCriterion("InTime not between", value1, value2, "intime");
            return (Criteria) this;
        }

        public Criteria andOuttimeIsNull() {
            addCriterion("OutTime is null");
            return (Criteria) this;
        }

        public Criteria andOuttimeIsNotNull() {
            addCriterion("OutTime is not null");
            return (Criteria) this;
        }

        public Criteria andOuttimeEqualTo(Date value) {
            addCriterion("OutTime =", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotEqualTo(Date value) {
            addCriterion("OutTime <>", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeGreaterThan(Date value) {
            addCriterion("OutTime >", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OutTime >=", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLessThan(Date value) {
            addCriterion("OutTime <", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLessThanOrEqualTo(Date value) {
            addCriterion("OutTime <=", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeIn(List<Date> values) {
            addCriterion("OutTime in", values, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotIn(List<Date> values) {
            addCriterion("OutTime not in", values, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeBetween(Date value1, Date value2) {
            addCriterion("OutTime between", value1, value2, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotBetween(Date value1, Date value2) {
            addCriterion("OutTime not between", value1, value2, "outtime");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("Position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("Position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("Position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("Position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("Position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("Position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("Position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("Position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("Position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("Position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("Position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("Position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("Position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("Position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andCarstateIsNull() {
            addCriterion("CarState is null");
            return (Criteria) this;
        }

        public Criteria andCarstateIsNotNull() {
            addCriterion("CarState is not null");
            return (Criteria) this;
        }

        public Criteria andCarstateEqualTo(Integer value) {
            addCriterion("CarState =", value, "carstate");
            return (Criteria) this;
        }

        public Criteria andCarstateNotEqualTo(Integer value) {
            addCriterion("CarState <>", value, "carstate");
            return (Criteria) this;
        }

        public Criteria andCarstateGreaterThan(Integer value) {
            addCriterion("CarState >", value, "carstate");
            return (Criteria) this;
        }

        public Criteria andCarstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("CarState >=", value, "carstate");
            return (Criteria) this;
        }

        public Criteria andCarstateLessThan(Integer value) {
            addCriterion("CarState <", value, "carstate");
            return (Criteria) this;
        }

        public Criteria andCarstateLessThanOrEqualTo(Integer value) {
            addCriterion("CarState <=", value, "carstate");
            return (Criteria) this;
        }

        public Criteria andCarstateIn(List<Integer> values) {
            addCriterion("CarState in", values, "carstate");
            return (Criteria) this;
        }

        public Criteria andCarstateNotIn(List<Integer> values) {
            addCriterion("CarState not in", values, "carstate");
            return (Criteria) this;
        }

        public Criteria andCarstateBetween(Integer value1, Integer value2) {
            addCriterion("CarState between", value1, value2, "carstate");
            return (Criteria) this;
        }

        public Criteria andCarstateNotBetween(Integer value1, Integer value2) {
            addCriterion("CarState not between", value1, value2, "carstate");
            return (Criteria) this;
        }

        public Criteria andCarstatedesIsNull() {
            addCriterion("CarStateDes is null");
            return (Criteria) this;
        }

        public Criteria andCarstatedesIsNotNull() {
            addCriterion("CarStateDes is not null");
            return (Criteria) this;
        }

        public Criteria andCarstatedesEqualTo(String value) {
            addCriterion("CarStateDes =", value, "carstatedes");
            return (Criteria) this;
        }

        public Criteria andCarstatedesNotEqualTo(String value) {
            addCriterion("CarStateDes <>", value, "carstatedes");
            return (Criteria) this;
        }

        public Criteria andCarstatedesGreaterThan(String value) {
            addCriterion("CarStateDes >", value, "carstatedes");
            return (Criteria) this;
        }

        public Criteria andCarstatedesGreaterThanOrEqualTo(String value) {
            addCriterion("CarStateDes >=", value, "carstatedes");
            return (Criteria) this;
        }

        public Criteria andCarstatedesLessThan(String value) {
            addCriterion("CarStateDes <", value, "carstatedes");
            return (Criteria) this;
        }

        public Criteria andCarstatedesLessThanOrEqualTo(String value) {
            addCriterion("CarStateDes <=", value, "carstatedes");
            return (Criteria) this;
        }

        public Criteria andCarstatedesLike(String value) {
            addCriterion("CarStateDes like", value, "carstatedes");
            return (Criteria) this;
        }

        public Criteria andCarstatedesNotLike(String value) {
            addCriterion("CarStateDes not like", value, "carstatedes");
            return (Criteria) this;
        }

        public Criteria andCarstatedesIn(List<String> values) {
            addCriterion("CarStateDes in", values, "carstatedes");
            return (Criteria) this;
        }

        public Criteria andCarstatedesNotIn(List<String> values) {
            addCriterion("CarStateDes not in", values, "carstatedes");
            return (Criteria) this;
        }

        public Criteria andCarstatedesBetween(String value1, String value2) {
            addCriterion("CarStateDes between", value1, value2, "carstatedes");
            return (Criteria) this;
        }

        public Criteria andCarstatedesNotBetween(String value1, String value2) {
            addCriterion("CarStateDes not between", value1, value2, "carstatedes");
            return (Criteria) this;
        }

        public Criteria andIntimestringIsNull() {
            addCriterion("InTimeString is null");
            return (Criteria) this;
        }

        public Criteria andIntimestringIsNotNull() {
            addCriterion("InTimeString is not null");
            return (Criteria) this;
        }

        public Criteria andIntimestringEqualTo(String value) {
            addCriterion("InTimeString =", value, "intimestring");
            return (Criteria) this;
        }

        public Criteria andIntimestringNotEqualTo(String value) {
            addCriterion("InTimeString <>", value, "intimestring");
            return (Criteria) this;
        }

        public Criteria andIntimestringGreaterThan(String value) {
            addCriterion("InTimeString >", value, "intimestring");
            return (Criteria) this;
        }

        public Criteria andIntimestringGreaterThanOrEqualTo(String value) {
            addCriterion("InTimeString >=", value, "intimestring");
            return (Criteria) this;
        }

        public Criteria andIntimestringLessThan(String value) {
            addCriterion("InTimeString <", value, "intimestring");
            return (Criteria) this;
        }

        public Criteria andIntimestringLessThanOrEqualTo(String value) {
            addCriterion("InTimeString <=", value, "intimestring");
            return (Criteria) this;
        }

        public Criteria andIntimestringLike(String value) {
            addCriterion("InTimeString like", value, "intimestring");
            return (Criteria) this;
        }

        public Criteria andIntimestringNotLike(String value) {
            addCriterion("InTimeString not like", value, "intimestring");
            return (Criteria) this;
        }

        public Criteria andIntimestringIn(List<String> values) {
            addCriterion("InTimeString in", values, "intimestring");
            return (Criteria) this;
        }

        public Criteria andIntimestringNotIn(List<String> values) {
            addCriterion("InTimeString not in", values, "intimestring");
            return (Criteria) this;
        }

        public Criteria andIntimestringBetween(String value1, String value2) {
            addCriterion("InTimeString between", value1, value2, "intimestring");
            return (Criteria) this;
        }

        public Criteria andIntimestringNotBetween(String value1, String value2) {
            addCriterion("InTimeString not between", value1, value2, "intimestring");
            return (Criteria) this;
        }

        public Criteria andOuttimestringIsNull() {
            addCriterion("OutTimeString is null");
            return (Criteria) this;
        }

        public Criteria andOuttimestringIsNotNull() {
            addCriterion("OutTimeString is not null");
            return (Criteria) this;
        }

        public Criteria andOuttimestringEqualTo(String value) {
            addCriterion("OutTimeString =", value, "outtimestring");
            return (Criteria) this;
        }

        public Criteria andOuttimestringNotEqualTo(String value) {
            addCriterion("OutTimeString <>", value, "outtimestring");
            return (Criteria) this;
        }

        public Criteria andOuttimestringGreaterThan(String value) {
            addCriterion("OutTimeString >", value, "outtimestring");
            return (Criteria) this;
        }

        public Criteria andOuttimestringGreaterThanOrEqualTo(String value) {
            addCriterion("OutTimeString >=", value, "outtimestring");
            return (Criteria) this;
        }

        public Criteria andOuttimestringLessThan(String value) {
            addCriterion("OutTimeString <", value, "outtimestring");
            return (Criteria) this;
        }

        public Criteria andOuttimestringLessThanOrEqualTo(String value) {
            addCriterion("OutTimeString <=", value, "outtimestring");
            return (Criteria) this;
        }

        public Criteria andOuttimestringLike(String value) {
            addCriterion("OutTimeString like", value, "outtimestring");
            return (Criteria) this;
        }

        public Criteria andOuttimestringNotLike(String value) {
            addCriterion("OutTimeString not like", value, "outtimestring");
            return (Criteria) this;
        }

        public Criteria andOuttimestringIn(List<String> values) {
            addCriterion("OutTimeString in", values, "outtimestring");
            return (Criteria) this;
        }

        public Criteria andOuttimestringNotIn(List<String> values) {
            addCriterion("OutTimeString not in", values, "outtimestring");
            return (Criteria) this;
        }

        public Criteria andOuttimestringBetween(String value1, String value2) {
            addCriterion("OutTimeString between", value1, value2, "outtimestring");
            return (Criteria) this;
        }

        public Criteria andOuttimestringNotBetween(String value1, String value2) {
            addCriterion("OutTimeString not between", value1, value2, "outtimestring");
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
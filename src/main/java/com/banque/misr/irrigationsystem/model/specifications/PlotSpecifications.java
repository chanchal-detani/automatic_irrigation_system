package com.banque.misr.irrigationsystem.model.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.banque.misr.irrigationsystem.entity.PlotEntity;
import com.banque.misr.irrigationsystem.entity.PlotEntity_;
import com.banque.misr.irrigationsystem.enums.CropType;
import com.banque.misr.irrigationsystem.enums.Status;

public final class PlotSpecifications {

	private PlotSpecifications() {}
	
	public static Specification<PlotEntity> hasName(String name) {
		return (root, query, cb) -> {
			String containsLikePattern = getContainsLikePattern(name);
			return cb.like(cb.lower(root.<String>get(PlotEntity_.name)), containsLikePattern.toLowerCase());
        };
	}

	public static Specification<PlotEntity> hasDescription(String description) {
		return (root, query, cb) -> {
			String containsLikePattern = getContainsLikePattern(description);
			return cb.like(cb.lower(root.<String>get(PlotEntity_.description)), containsLikePattern.toLowerCase());
        };
	}
	
	public static Specification<PlotEntity> isActive() {
		return (root, query, cb) -> cb.equal(root.<Boolean>get(PlotEntity_.active), true);
	}
	
	public static Specification<PlotEntity> hasStatus(String status) {
		return (root, query, cb) -> cb.equal(root.<Status>get(PlotEntity_.status), Status.fromValue(status.toUpperCase()));
	}
	
	public static Specification<PlotEntity> hasCropType(String cropType) {
		return (root, query, cb) -> cb.equal(root.<CropType>get(PlotEntity_.cropType), CropType.fromValue(cropType.toUpperCase()));
	}
	
	private static String getContainsLikePattern(String searchText) {
		if (searchText == null || searchText.isEmpty()) {
            return "%";
        }
        else {
            return "%" + searchText.toLowerCase() + "%";
        }
	}
}

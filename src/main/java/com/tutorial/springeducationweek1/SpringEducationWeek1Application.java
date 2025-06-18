package com.tutorial.springeducationweek1;

import com.tutorial.springeducationweek1.domain.dto.CategoryFlatDto;
import com.tutorial.springeducationweek1.domain.dto.CategoryTreeDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEducationWeek1Application {

    public static void main(String[] args) {

        // 1. Flat한 리스트 준비
//        List<CategoryFlatDto> flatList = List.of(
//            new CategoryFlatDto(1L, "전자제품", null),
//            new CategoryFlatDto(2L, "노트북", 1L),
//            new CategoryFlatDto(3L, "스마트폰", 1L),
//            new CategoryFlatDto(4L, "게이밍 노트북", 2L),
//            new CategoryFlatDto(5L, "주방가전", 1L),
//            new CategoryFlatDto(6L, "믹서기", 5L),
//            new CategoryFlatDto(7L, "핸드폰 케이스", 3L)
//        );
//
//        // 재귀 호출방식
//        long recStart = System.nanoTime();
//        List<CategoryTreeDto> recData = treeRecursive(flatList, null);
//        System.out.println(JsonUtils.toJson(recData));
//        long recEnd = System.nanoTime();
//        System.out.println("재귀 방식: " + ((recEnd - recStart) / 1_000_000.0) + " ms");
//
//        // Map 방식
//        long mapStart = System.nanoTime();
//        List<CategoryTreeDto> topNode = new ArrayList<>();
//        Map<Long, CategoryTreeDto> treeMap = new HashMap<>();
//
//        for (CategoryFlatDto flat : flatList) {
//            CategoryTreeDto categoryTreeDto = new CategoryTreeDto();
//            categoryTreeDto.setId(flat.getId());
//            categoryTreeDto.setName(flat.getName());
//            treeMap.put(flat.getId(), categoryTreeDto);
//        }
//
//        for(CategoryFlatDto flat : flatList) {
//            CategoryTreeDto node = treeMap.get(flat.getId());
//
//            if(flat.getParentId() == null) {
//                topNode.add(node);
//            } else {
//                CategoryTreeDto parent = treeMap.get(flat.getParentId());
//                parent.getChildren().add(node);
//            }
//        }
//
//
//        printTree(topNode,0);
//        long mapEnd = System.nanoTime();
//        System.out.println("Map 방식: " + ((mapEnd - mapStart) / 1_000_000.0) + " ms");

        SpringApplication.run(SpringEducationWeek1Application.class, args);
    }

//    public static void printTree(List<CategoryTreeDto> treeList, int depth) {
//        for(CategoryTreeDto node : treeList) {
//            System.out.println("  ".repeat(depth) + "- " +node.getName());
//            printTree(node.getChildren(), depth + 1);
//        }
//    }
//
//    public static List<CategoryTreeDto> treeRecursive(List<CategoryFlatDto> flatList, Long parentId) {
//        List<CategoryTreeDto> result = new ArrayList<>();
//
//        for (CategoryFlatDto flat : flatList) {
//            if (Objects.equals(flat.getParentId(), parentId)) {
//                CategoryTreeDto node = new CategoryTreeDto();
//                node.setId(flat.getId());
//                node.setName(flat.getName());
//                node.setChildren(treeRecursive(flatList, flat.getId())); // 자식 재귀 탐색
//                result.add(node);
//            }
//        }
//
//        return result;
//    }

}

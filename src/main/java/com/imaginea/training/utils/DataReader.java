package com.imaginea.training.utils;

import java.util.Set;

public interface DataReader<E, T> {

	Set<E> getData(T sourcePath);
}

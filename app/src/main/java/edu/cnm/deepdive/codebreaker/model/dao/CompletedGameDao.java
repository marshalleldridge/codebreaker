package edu.cnm.deepdive.codebreaker.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.codebreaker.model.entity.CompletedGame;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface CompletedGameDao {

  @Insert
  Single<Long> insert(CompletedGame game);

  @Insert
  Single<List<Long>> insert(CompletedGame... games);
  //the ...(var agrs) allows this method to be invoked with multiple instances seperated by commas
  //insert 0 or more items in an array/var args

  @Insert
  Single<List<Long>> insert(Collection<CompletedGame> games);
  //insert 0 or more items in a collection/set

  @Update
  Single<Integer> update(CompletedGame game);

  @Update
  Single<Integer> update(CompletedGame... games);

  @Update
  Single<Integer> update(Collection<CompletedGame> games);

  @Delete
  Single<Integer> delete(CompletedGame game);

  @Delete
  Single<Integer> delete(CompletedGame... games);

  @Delete
  Single<Integer> delete(Collection<CompletedGame> games);

  @Query("SELECT * FROM completed_game "
      + "WHERE code_length = :codeLength AND pool_size = :poolSize "
      + "ORDER BY attempts ASC")
  LiveData<List<CompletedGame>> selectByAttempts(int codeLength, int poolSize);

  @Query("SELECT * FROM completed_game "
      + "WHERE code_length = :codeLength AND pool_size = :poolSize "
      + "ORDER BY completed DESC")
  LiveData<List<CompletedGame>> selectByCompleted(int codeLength, int poolSize);

}
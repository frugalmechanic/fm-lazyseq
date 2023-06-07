/*
 * Copyright 2014 Frugal Mechanic (http://frugalmechanic.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fm.lazyseq

/**
 * Eliminates duplicate records that are next to each other based on a key within that record
 */
final private class UniqueLazySeq[A, K](reader: LazySeq[A], key: A => K) extends LazySeq[A] {
  def foreach[U](f: A => U): Unit = {
    var isFirst: Boolean = true
    var current: A = null.asInstanceOf[A]
    
    reader.foreach { (next: A) =>
      if (isFirst) {
        current = next
        isFirst = false
      } else if (key(current) != key(next)) {
        f(current)
        current = next
      } else {
        // Dupe record so skip next
      }
    }
    
    if (!isFirst) f(current)
  }
}
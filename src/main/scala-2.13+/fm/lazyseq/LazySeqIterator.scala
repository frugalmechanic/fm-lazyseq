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

import java.io.Closeable

trait LazySeqIterator[+A] extends scala.collection.BufferedIterator[A] with Closeable {
  def close(): Unit
  def hasNext: Boolean
  def head: A
  final override def headOption: Option[A] = if (hasNext) Some(head) else None
  def next(): A
}
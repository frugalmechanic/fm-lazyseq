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
 * An empty resource reader
 */
// TODO fixme - This was originally private but doesn't seem to compile for Scala 2.12 for some reason
object EmptyLazySeq extends LazySeq[Nothing] {
  final def foreach[U](f: Nothing => U): Unit = {}
}
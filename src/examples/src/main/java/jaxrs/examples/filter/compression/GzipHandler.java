/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package jaxrs.examples.filter.compression;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.ws.rs.BindingPriority;

import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReadFromHandler;
import javax.ws.rs.ext.ReadFromHandlerContext;
import javax.ws.rs.ext.WriteToHandler;
import javax.ws.rs.ext.WriteToHandlerContext;

/**
 * 
 * @author Santiago Pericas-Geertsen
 */
@Provider
@Gzipped
@BindingPriority(BindingPriority.DECODER)
public class GzipHandler implements ReadFromHandler, WriteToHandler {

    @Override
    public Object readFrom(ReadFromHandlerContext ctx) throws IOException {
        if (!gzipEncoded(ctx)) {
            return ctx.proceed();
        } else {
            InputStream old = ctx.getInputStream();
            ctx.setInputStream(new GZIPInputStream(old));
            try {
                return ctx.proceed();
            } finally {
                ctx.setInputStream(old);
            }
        }
    }

    @Override
    public void writeTo(WriteToHandlerContext ctx) throws IOException {
        if (!acceptsGzip(ctx)) {
            ctx.proceed();
        } else {
            OutputStream old = ctx.getOutputStream();
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(old);
            ctx.setOutputStream(gzipOutputStream);
            try {
                ctx.proceed();
            } finally {
                gzipOutputStream.finish();
                ctx.setOutputStream(old);
            }
        }
    }

    private boolean acceptsGzip(WriteToHandlerContext ctx) {
        return true;        // TODO
    }

    private boolean gzipEncoded(ReadFromHandlerContext ctx) {
        return true;        // TODO
    }
}
